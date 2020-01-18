(ns blog-backend.domain.interactors.article
  (:refer-clojure :exclude [update find get])
  (:require [blog-backend.domain.repository.article :refer [save, modify find check_publish set_publish]]))

(defn create [article repository]
  (save repository article))

(defn update [article repository]
  (modify repository article))

(defn get [article repository]
  (find repository article))

(defn is_publish [article repository]
  (check_publish repository article))

(defn publish [article repository]
  (set_publish repository article))
