(ns dev.codecarver.api.main
  (:use ring.adapter.jetty)
  (:require [compojure.core :refer :all]
            [compojure.route :as route])
  (:require [ring.middleware.defaults :refer :all])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:require [validateur.validation :refer :all])
  (:require [dev.codecarver.api.article :refer [create_article]]))


(defn augment_response [body]
  (let [validation (get body :validation_error) ]
    (if (nil? validation)
      {:status "Ok" :code 200 :result body}
      {:status "Bad Request" :code 400 :messages validation })))

(defn augment_response_error []
  {:status "Internal Server Error" :code 500})

(defn wrap-response [handler]
  (fn [request]
    (try
       (let [response (handler request) body (get response :body)]
         (assoc response :body (augment_response body)))
       (catch Exception e
         {:status 500 :body (augment_response_error)}))))


(defroutes app
           (->
             (GET "/article" [] create_article)
             (wrap-defaults api-defaults)
             (wrap-params)
             (wrap-response)
             (wrap-json-response))
           (route/not-found "<h1>Page not found</h1>"))

(defn -main [& args]
  (run-jetty app {:port 3000})
  )





