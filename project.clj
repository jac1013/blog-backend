(defproject dev.codecarver "0.1.0-SNAPSHOT"
  :description "Just a personal Blog"
  :url "http://to-be-defined.com"
  :license {:name "MIT"
            :url "https://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-core "1.8.1"]
                 [ring/ring-jetty-adapter "1.8.1"]
                 [ring/ring-json "0.5.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [com.novemberain/validateur "2.6.0"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [org.postgresql/postgresql "42.2.14"]
                 [lynxeyes/dotenv "1.1.0"]
                 [org.clojure/data.generators "1.0.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [org.clojure/core.incubator "0.1.4"]
                 [clj-time "0.15.2"]
                 [ring-cors "0.1.13"]]
  :main dev.codecarver.api.core
  :aot [dev.codecarver.api.core]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all :main dev.codecarver.api.core}
             :api {:main dev.codecarver.api.core}
             :core-test {:main dev.codecarver.core}
             :cloverage  {:plugins [[lein-cloverage "1.0.11-20180518.155437-26"]]
                          :cloverage {:test-ns-regex [#"^((?!integration).)*$"]}}}
  :aliases {"api" ["with-profile" "api" "run"]}
  :plugins [[lein-kibit "0.1.8"]
            [lein-ancient "0.6.15"]
            [lein-cloverage "1.1.2"]
            [lein-nvd "1.3.0"]
            [lein-cljfmt "0.6.6"]]
  :test-selectors {:default (complement :integration)
                   :integration :integration})




