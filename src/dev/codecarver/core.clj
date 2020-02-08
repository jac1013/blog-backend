(ns dev.codecarver.core
  (:gen-class)
  (:refer-clojure :exclude [update get])
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create
                                                               update
                                                               get
                                                               is_publish
                                                               publish
                                                               un_publish]]))

(defn -main
  "Main entry point working as an integration tests"
  [& args]
  (let [interactor (articleInteractor)]
    (println (create interactor {:title "longer than ten characters title" :body "He we have a body" :is_publish false}))
    (println (update interactor {:id 1 :title "longer than ten characters title2" :body "He we have a body2"}))
    (println (get interactor 1))
    (println (is_publish interactor 1))
    (println (publish interactor 1))
    (println (is_publish interactor 1))
    (println (un_publish interactor 1))))



