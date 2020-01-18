(ns blog-backend.domain.interactors.article
  (:refer-clojure :exclude [update find])
  (:require [blog-backend.domain.repository.article :refer [save, modify]]))

(defn create [article repository]
  (save repository article))

(defn update [article repository]
  (modify repository article))
