(ns dev.codecarver.api.routes.article
  (:require [compojure.core :refer [defroutes routes wrap-routes GET POST PUT]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response wrap-json-body]])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [dev.codecarver.api.controllers.article :refer [get-article
                                                            get-articles]]))

(defroutes article_routes
  (wrap-params
   (routes
    (GET "/article/:id" [] get-article)
    (GET "/articles" [] get-articles))))
