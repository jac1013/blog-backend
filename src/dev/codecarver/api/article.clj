(ns dev.codecarver.api.article

  (:require [dev.codecarver.domain.interactors.implementations.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article :refer [create]]))

(defn create_article [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (create (articleInteractor) {:id 1 :hello (get-in request [:params "ciao"])})})
