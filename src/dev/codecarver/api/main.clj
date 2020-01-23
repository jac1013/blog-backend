(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [reitit.ring :as ring])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [dev.codecarver.api.article :refer [create_article]]))


(def router
  (ring/router
    ["/article" {:get {:middleware [[wrap-params] [wrap-json-response]]
                       :handler create_article}} ]))

(def app (ring/ring-handler router))

(run-jetty app {:port 3000})



