use tonic::{transport::Server, Request, Response, Status};
use compute::execution_engine_server::{ExecutionEngine, ExecutionEngineServer};
use compute::{TaskRequest, TaskResponse, NodeStatus, Empty};

pub mod compute {
    tonic::include_proto!("compute");
}

#[derive(Default)]
pub struct AresWorker {}

#[tonic::async_trait]
impl ExecutionEngine for AresWorker {
    async fn execute_task(
        &self,
        request: Request<TaskRequest>,
    ) -> Result<Response<TaskResponse>, Status> {
        let req = request.into_inner();
        println!("Received task: {}", req.task_id);
        
        Ok(Response::new(TaskResponse {
            task_id: req.task_id,
            stdout_output: b"Hello from Rust worker".to_vec(),
            execution_time_ns: 0,
            exit_code: "0".to_string(),
        }))
    }

    async fn stream_heartbeat(
        &self,
        _request: Request<NodeStatus>,
    ) -> Result<Response<Empty>, Status> {
        Ok(Response::new(Empty {}))
    }
}

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let addr = "[::1]:50051".parse()?;
    let worker = AresWorker::default();

    println!("Rust agent listening on {}", addr);

    Server::builder()
        .add_service(ExecutionEngineServer::new(worker))
        .serve(addr)
        .await?;

    Ok(())
}