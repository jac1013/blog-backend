(ns blog-backend.core
  (:gen-class)
  (:refer-clojure :exclude [update get])
  (:require [blog-backend.repository.postgresql.article :refer [articleRepo]])
  (:require [blog-backend.domain.interactors.article :refer [create
                                                             update
                                                             get
                                                             is_publish
                                                             publish
                                                             un_publish]]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (create {:id 1} (articleRepo)))
  (println (update {:id 2} (articleRepo)))
  (println (get 5 (articleRepo)))
  (println (is_publish 5 (articleRepo)))
  (println (publish 5 (articleRepo)))
  (println (un_publish 5 (articleRepo))))

