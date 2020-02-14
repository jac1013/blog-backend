(ns dev.codecarver.core
  (:gen-class)
  (:refer-clojure :exclude [update get list])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create
                                                                          update_
                                                                          get_
                                                                          is_publish
                                                                          publish
                                                                          list_]]))

(defn -main
  "Main entry point working as an integration tests"
  [& args]
  (let [interactor (articleInteractor)]
    (println (create interactor {:title "longer than ten characters title" :body "He we have a body" :is_publish false}))
    (println (update_ interactor {:id 1 :title "longer than ten characters title2" :body "He we have a body2"}))
    (println (get_ interactor 1))
    (println (is_publish interactor 1))
    (println (publish interactor 1))
    (println (is_publish interactor 1))
    (println (count (list_ interactor)))))
