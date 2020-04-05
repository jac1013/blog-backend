(ns dev.codecarver.api.routes.like
  (:require [compojure.core :refer [defroutes routes wrap-routes GET POST PUT DELETE]])
  (:require [compojure.coercions :refer [as-int]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response wrap-json-body]])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [dev.codecarver.api.controllers.like :refer [like unlike]]))


(defroutes like-routes
             (routes
               (wrap-json-body
                 (POST "/like" [] like) {:keywords? true})
               (wrap-params
                 (DELETE "/unlike/:id" [id :<< as-int] unlike))))
