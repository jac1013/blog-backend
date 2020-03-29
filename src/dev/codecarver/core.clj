(ns dev.codecarver.core
  (:gen-class)
  (:refer-clojure :exclude [update get list])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create!
                                                                          update!
                                                                          get
                                                                          publish?
                                                                          publish
                                                                          get-all]]))

(defn -main
  "Main entry point working as an integration tests"
  [& args]
  (let [interactor (articleInteractor)]
    (println (create! interactor {:title "longer than ten characters title" :body "He we have a body" :publish? false}))
    (println (update! interactor {:id 1 :title "longer than ten characters title2" :body "He we have a body2"}))
    (println (get interactor 1))
    (println (publish? interactor 1))
    (println (publish interactor 1))
    (println (publish? interactor 1))
    (println (count (get-all interactor)))))
