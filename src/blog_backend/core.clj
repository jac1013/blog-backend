(ns blog-backend.core
  (:gen-class)
  (:refer-clojure :exclude [update])
  (:require [blog-backend.domain.interactors.article :refer [create update]])
  (:require [blog-backend.repository.postgresql.article :refer [articleRepo]]))


;(defn new_article_repo [] (fn [] (ArticleRepo.)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (create {:id 1} (articleRepo)))
  (println (update {:id 2})))

