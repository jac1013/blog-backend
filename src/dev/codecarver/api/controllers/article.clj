(ns dev.codecarver.api.controllers.article
  (:require [dev.codecarver.domain.interactors.implementations.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article :refer [create]]))

(defn create_article [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (create (articleInteractor) {:id 1 :title "I have more than ten characters"
                                      :body "I'm just a body that's not empty"
                                      :hello (get-in request [:params :ciao])})})
