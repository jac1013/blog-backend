(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [dev.codecarver.api.article :refer [create_article]]))


(def app
  (wrap-json-response create_article))

(run-jetty app {:port 3000})
