(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes wrap-routes GET routes]]
            [compojure.route :as route])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [dev.codecarver.api.routes.article :refer [article_routes]]))

(def app
  (routes
   (-> article_routes
       (wrap-defaults api-defaults)
       wrap-response
       wrap-json-response)
   (route/not-found "<h1>Page not found</h1>")))

(defn -main []
  (run-jetty app {:port 3000}))
