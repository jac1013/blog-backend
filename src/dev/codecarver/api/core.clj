(ns dev.codecarver.api.core
  (:gen-class)
  (:use ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes wrap-routes GET routes]]
            [compojure.route :as route])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [dev.codecarver.api.routes.article :refer [article-routes]])
  (:require [dev.codecarver.api.routes.like :refer [like-routes]])
  (:require [dev.codecarver.util.env :refer [get-env]]))

(def app
  (routes
   (-> article-routes
       (wrap-defaults api-defaults)
       (wrap-response)
       (wrap-json-response))
   (-> like-routes
       (wrap-defaults api-defaults)
       (wrap-response)
       (wrap-json-response))
   (route/not-found "<h1>Page not found</h1>")))

(defn -main [& args]
  "Main for running the Web server application"
  (run-jetty app {:port (Integer/parseInt (get-env :WEB_PORT 3000))}))

