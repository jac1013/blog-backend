(defproject dev.codecarver "0.1.0-SNAPSHOT"
  :description "Just a personal Blog"
  :url "http://to-be-defined.com"
  :license {:name "MIT"
            :url "https://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-jetty-adapter "1.8.0"]
                 [ring/ring-json "0.5.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [com.novemberain/validateur "2.6.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]]
  :main dev.codecarver.core
  :aot [dev.codecarver.core]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :api {:main dev.codecarver.api.main}
             :core-test {:main dev.codecarver.core}}
  :aliases {"api" ["with-profile" "api" "run"]
            "core-test" ["with-profile" "core-test" "run"]}
  :plugins [[lein-kibit "0.1.8"]
            [lein-ancient "0.6.15"]
            [lein-cloverage "1.1.2"]
            [lein-nvd "1.3.0"]])


