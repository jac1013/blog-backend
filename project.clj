(defproject blog-backend "0.1.0-SNAPSHOT"
  :description "Just a personal Blog"
  :url "http://to-be-defined.com"
  :license {:name "MIT"
            :url "https://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "2.0.0"]]
  :main blog-backend.core
  :aot [blog-backend.core]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
