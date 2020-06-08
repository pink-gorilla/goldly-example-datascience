(defproject org.pinkgorilla/goldly-example-datascience "0.0.1-SNAPSHOT"
  :description "goldly datascience examples"
  :license {:name "MIT"}
  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/release_username
                                     :password :env/release_password
                                     :sign-releases false}]]
  :min-lein-version "2.9.3"
  :min-java-version "1.11"
  :jvm-opts ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/jul-factory"]

  :release-tasks [["vcs" "assert-committed"]
                  ["bump-version" "release"]
                  ["vcs" "commit" "Release %s"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy"]
                  ["bump-version"]
                  ["vcs" "commit" "Begin %s"]
                  ["vcs" "push"]]

  :managed-dependencies [[org.clojure/core.async "1.2.603"]
                         [org.clojure/tools.logging "1.1.0"]
                         [org.clojure/core.memoize "1.0.236"]
                         ; libpythonclj fixes
                         [net.java.dev.jna/jna "5.5.0"]
                         [org.ow2.asm/asm "8.0.1"]]

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.pinkgorilla/goldly "0.2.3"]
                 [org.clojure/tools.logging "1.1.0"] ; needed by clojisr
                 [org.pinkgorilla/clojisr-gorilla "0.0.6"]]

  :source-paths ["src"]
  :resource-paths ["resources"]

  :aliases {"goldly" ^{:doc "Runs goldly app (with only default system components)"}
            ["run" "-m" "goldly.app"]

            "demo" ^{:doc "Runs goldly app (with datascience components)"}
            ["run" "-m" "goldly.app" "./src/systems/"]})

