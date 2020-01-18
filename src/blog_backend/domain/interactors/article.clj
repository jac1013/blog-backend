(ns blog-backend.domain.interactors.article
  (:refer-clojure :exclude [update find])
  (:require [blog-backend.domain.repository.article :as interactor :refer [save, modify]]))

(defn create [article repository]
  (interactor/save repository article))

(defn update [article repository]
  (interactor/modify repository article))
