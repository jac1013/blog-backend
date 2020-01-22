(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [dev.codecarver.api.article :refer [create_article]]))


(def app
  ( -> create_article
       (wrap-params)
       (wrap-json-response)))

(run-jetty app {:port 3000})



