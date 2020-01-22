(ns dev.codecarver.domain.interactors.implementations.article
  (:refer-clojure :exclude [update find get])
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.repository.article :refer [save
                                                              modify
                                                              find]])
  (:require [dev.codecarver.domain.interactors.article :refer [ArticleInteractor]]))

(deftype ArticleInteractorImpl [repository]
  ArticleInteractor
  (create [_ article] (save repository article))
  (update [_ article] (modify repository article))
  (get [_ id] (find repository id))
  (is_publish [_ id] (modify repository id))
  (publish [_ id] (modify repository id))
  (un_publish [_ id] (modify repository id)))

(defn articleInteractor []
  (ArticleInteractorImpl. (articleRepo)))
