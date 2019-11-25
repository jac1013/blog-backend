(ns blog-backend.domain.interactors.article
  (:require [blog-backend.domain.repository.article :refer [createArticle]])
  (:import (blog_backend.domain.repository.article ArticleRepo)))

(defn create [article]
  (let [ar (ArticleRepo.)]
        (createArticle ar article)))
