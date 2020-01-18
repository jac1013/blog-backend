(ns blog-backend.domain.interactors.article
  (:refer-clojure :exclude [update find])
  (:require [blog-backend.domain.repository.article :as interactor :refer [save, modify]])
  (:import (blog_backend.domain.repository.article ArticleRepo)))

(defn create [article repository]
  (interactor/save repository article))

(defn update [article]
  (let [ar (ArticleRepo.)]
    (interactor/modify ar article)))
