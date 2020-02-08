(ns dev.codecarver.api.controllers.article
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create]]))

(defn create_article [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (create (articleInteractor) {:title "I have more than ten characters"
                                      :body "I'm just a body that's not empty"})})
