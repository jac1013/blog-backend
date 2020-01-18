(ns blog-backend.core
  (:gen-class)
  (:refer-clojure :exclude [update])
  (:require [blog-backend.domain.interactors.article :refer [create update]])
  (:import (blog_backend.domain.repository.article ArticleRepo)))


;(defn new_article_repo [] (fn [] (ArticleRepo.)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (create {:id 1} (ArticleRepo.)))
  (println (update {:id 2})))

