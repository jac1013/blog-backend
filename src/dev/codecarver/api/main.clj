(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [compojure.core :refer :all]
            [compojure.route :as route])
  (:require [ring.middleware.defaults :refer :all])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [dev.codecarver.api.article :refer [create_article]]))


(defroutes app
           (->
             (GET "/article" [] create_article)
             (wrap-defaults api-defaults)
             (wrap-params)
             (wrap-json-response))
           (route/not-found "<h1>Page not found</h1>"))

(run-jetty app {:port 3000})



