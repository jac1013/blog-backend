(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes wrap-routes GET routes]]
            [compojure.route :as route])
  (:require [dev.codecarver.api.routes.article :refer [article_routes]]))

(def app
  (routes
   article_routes
   (route/not-found "<h1>Page not found</h1>")))

(defn -main []
  (run-jetty app {:port 3000}))
