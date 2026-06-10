fn main() {
    tonic_build::configure()
        .compile(&["proto/compute.proto"], &["proto"])
        .unwrap();
}
