workspace(name = "protoeditor")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_file")
load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")

# The plugin api for IntelliJ UE.
http_archive(
    name = "idea_ue_2020_1",
    build_file = "@//build_support/external:BUILD.idea_ue",
    sha256 = "5a75b7a65396c449f4394c969ede7a0e8f7c657a9b6cc309fe711eb3199e1ca1",
    strip_prefix = "idea-IU-201.8538.31",
    url = "https://download-cf.jetbrains.com/idea/ideaIU-2020.1.3-no-jbr.tar.gz",
)

# Python plugin for IntelliJ CE 2019.3. Required at compile-time for python-specific features.
http_archive(
    name = "python_2020_1",
    build_file = "@//build_support/external:BUILD.idea_python",
    sha256 = "895907a3fb1bd7723a415630be7b2098dfcc53284f05ea7e3f8c27e064c08b31",
    url = "https://plugins.jetbrains.com/files/631/91340/python.zip",
)

# Go plugin for IntelliJ UE. Required at compile-time for Bazel integration.
http_archive(
    name = "go_2020_1",
    build_file = "@//build_support/external:BUILD.idea_go",
    sha256 = "df90d16313e7b06f483e9df36c20d3e911eda75eab957acd5ad121a380d8d800",
    url = "https://plugins.jetbrains.com/files/9568/91477/intellij-go-201.8538.31.199.zip",
)

http_archive(
    name = "erlang_2020_1",
    build_file = "@//build_support/external:BUILD.idea_erlang",
    sha256 = "8b1694978ae6f2b7e7801904d29c5c814f33b144d34a47e72b0df6b2476695bd",
    url = "https://plugins.jetbrains.com/files/7083/83262/intellij-erlang-0.11.1059.zip",
)

# jflex for IDEA
jvm_maven_import_external(
    name = "idea_jflex",
    artifact = "org.jetbrains.intellij.deps.jflex:jflex:1.7.0-2",
    artifact_sha256 = "8a436449844a9ed4e6d371f3276f571dd116512b089ec84d478ed93ae9aa8d49",
    licenses = ["notice"],  # BSD
    server_urls = ["https://jetbrains.bintray.com/intellij-third-party-dependencies"],
    generated_rule_name = "idea_jflex_lib",
)

# jflex skeleton
http_file(
    name = "idea_jflex_skeleton",
    executable = 0,
    urls = [
        "https://raw.githubusercontent.com/JetBrains/intellij-community/843d74524f93e65227cf0321b078227fa911a7c1/tools/lexer/idea-flex.skeleton"
    ],
    sha256 = "c6fa83affcbe6cec9c7345fbeccc6dfc6f32341ab9fdec42d7f2c3e008ae66d3",
)

http_archive(
    name = "grammar_kit",
    build_file = "//build_support/external:BUILD.grammar_kit",
    sha256 = "9cfc31d090de5c68ff6e3fd265615168ec1d28a95984c6d96cb0ebabaab08562",
    url = "https://github.com/JetBrains/Grammar-Kit/releases/download/2020.1/grammar-kit-2020.1.zip",
)

jvm_maven_import_external(
    name = "truth",
    artifact = "com.google.truth:truth:1.0.1",
    artifact_sha256 = "1ccf4334e7a94cf00a20a619b5462b53acf3274e00b70498bf5b28a3bc1be9b1",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["https://repo.maven.apache.org/maven2"],
)

jvm_maven_import_external(
    name = "diffutils",
    artifact = "com.googlecode.java-diff-utils:diffutils:1.3.0",
    artifact_sha256 = "61ba4dc49adca95243beaa0569adc2a23aedb5292ae78aa01186fa782ebdc5c2",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["https://repo.maven.apache.org/maven2"],
)

jvm_maven_import_external(
    name = "mockito",
    artifact = "org.mockito:mockito-core:3.4.2",
    artifact_sha256 = "357e4bcdf9d262a054e855470c158dd54c197e414e151d7116cbacdaac895cc6",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["https://repo.maven.apache.org/maven2"],
)

http_archive(
    name = "com_google_protobuf",
    sha256 = "71030a04aedf9f612d2991c1c552317038c3c5a2b578ac4745267a45e7037c29",
    strip_prefix = "protobuf-3.12.3",
    url = "https://github.com/protocolbuffers/protobuf/archive/v3.12.3.tar.gz",
)
load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")
protobuf_deps()

http_archive(
    name = "com_google_protobuf_javalite",
    sha256 = "d8b0e0ca38724ffe667c7db4803b8315690c7bb26bcf1c5b6904d0d4639495ff",
    strip_prefix = "protobuf-7b64714af67aa967dcf941df61fe5207975966be",
    url = "https://github.com/protocolbuffers/protobuf/archive/7b64714af67aa967dcf941df61fe5207975966be.tar.gz",
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "2d536797707dd1697441876b2e862c58839f975c8fc2f0f96636cbd428f45866",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.23.5/rules_go-v0.23.5.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.23.5/rules_go-v0.23.5.tar.gz",
    ],
)

load("@io_bazel_rules_go//go:deps.bzl", "go_rules_dependencies", "go_register_toolchains")
go_rules_dependencies()
go_register_toolchains()


http_archive(
    name = "com_github_grpc_grpc",
    urls = ["https://github.com/grpc/grpc/archive/v1.30.1.tar.gz"],
    sha256 = "d6a10be7e803cc7ba73b3a03d34f6d18c046b562e4b08752c17aa978464baea3",
    strip_prefix = "grpc-1.30.1",
)

load("@com_github_grpc_grpc//bazel:grpc_deps.bzl", "grpc_deps")
grpc_deps()
