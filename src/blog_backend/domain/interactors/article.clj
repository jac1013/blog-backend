(ns blog-backend.domain.interactors.article
  (:require [blog-backend.domain.repository.article :refer [save]])
  (:import (blog_backend.domain.repository.article ArticleRepo)))

(defn create [article]
  (let [ar (ArticleRepo.)]
        (save ar article)))
