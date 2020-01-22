(ns dev.codecarver.api.article
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.interactors.implementations.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article :refer [create]]))

(defn create_article [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (create (articleInteractor (articleRepo)) {:id 1})})
