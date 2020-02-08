(ns dev.codecarver.api.routes.article
  (:require [compojure.core :refer [defroutes wrap-routes GET]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [dev.codecarver.api.controllers.article :refer [create_article]]))

(defroutes article_routes
  (->
   (GET "/article" [] create_article)
   (wrap-defaults api-defaults)
   wrap-params
   (wrap-routes wrap-response)
   wrap-json-response))
