fn main() {
    tonic_build::configure()
        .compile_protos(&["proto/compute.proto"], &["proto"])
        .unwrap();
}
