(ns dev.codecarver.core
  (:gen-class)
  (:refer-clojure :exclude [update get])
  (:require [dev.codecarver.repository.postgresql.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.interactors.article :refer [create
                                                               update
                                                               get
                                                               is_publish
                                                               publish
                                                               un_publish
                                                               articleInteractor]]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [interactor (articleInteractor (articleRepo))]
    (println (create interactor {:id 1}))
    (println (update interactor {:id 2}))
    (println (get interactor 5))
    (println (is_publish interactor 5))
    (println (publish interactor 5))
    (println (un_publish interactor 5))))


