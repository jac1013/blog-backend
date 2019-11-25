(ns blog-backend.core
  (:gen-class)
  (:require [blog-backend.domain.interactors.article :refer [create]]))


;(defn new_article_repo [] (fn [] (ArticleRepo.)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (create {:id 1})))
