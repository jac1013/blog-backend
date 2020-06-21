(ns dev.codecarver.api.core
  (:gen-class)
  (:use ring.adapter.jetty)
  (:require [compojure.core :refer [wrap-routes routes]]
            [compojure.route :as route])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [dev.codecarver.util.env :refer [get-env]])
  (:require [ring.middleware.cors :refer [wrap-cors]])
  (:require [dev.codecarver.api.routes.app :refer [app-routes]]))

(def app
  (routes
   (-> app-routes
       (wrap-defaults api-defaults)
       (wrap-response)
       (wrap-json-response)
       (wrap-cors :access-control-allow-origin [#"http://localhost:3000" #"https://codecarver.dev"]
                  :access-control-allow-methods [:get :put :post :delete]))
   (route/not-found "<h1>Page not found</h1>")))

(defn -main [& args]
  "Main for running the Web server application"
  (run-jetty app {:port (Integer/parseInt (get-env :WEB_PORT 3000))}))

