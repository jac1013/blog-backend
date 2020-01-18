(ns blog-backend.domain.interactors.article
  (:refer-clojure :exclude [update find get])
  (:require [blog-backend.domain.repository.article :refer [save, modify find]]))

(defn create [article repository]
  (save repository article))

(defn update [article repository]
  (modify repository article))

(defn get [article repository]
  (find repository article))
