workspace(name = "n_puzzle")

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

git_repository(
    name = "rules_clojure",
    remote = "git@github.com:simuons/rules_clojure.git",
    commit = "9a42065f3b1977b81f4cc42e5cf1d838de3ba7a8",
)

load("@rules_clojure//:runtime.bzl", "clojure_runtime")

clojure_runtime()

