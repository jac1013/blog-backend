(ns dev.codecarver.api.routes.app
  (:require [compojure.core :refer [defroutes routes wrap-routes GET POST PUT]])
  (:require [dev.codecarver.api.routes.article :refer [article-routes]])
  (:require [dev.codecarver.api.routes.like :refer [like-routes]]))

(defroutes app-routes
  article-routes
  like-routes)
