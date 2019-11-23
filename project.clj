(defproject blog-backend "0.1.0-SNAPSHOT"
  :description "Just a personal Blog"
  :url "http://to-be-defined.com"
  :license {:name "MIT"
            :url "https://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "3.10.0"]]
  :main blog-backend.core
  :aot [blog-backend.core]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-kibit "0.1.8"]
            [lein-ancient "0.6.15"]
            [lein-cloverage "1.1.2"]
            [lein-nvd "1.3.0"]])

