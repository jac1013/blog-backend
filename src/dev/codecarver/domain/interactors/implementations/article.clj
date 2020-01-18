(ns dev.codecarver.domain.interactors.implementations.article
  (:refer-clojure :exclude [update find get])
  (:require [dev.codecarver.domain.repository.article :refer [save
                                                              modify
                                                              find
                                                              check_publish
                                                              set_publish
                                                              set_un_publish]])
  (:require [dev.codecarver.domain.interactors.article :refer [ArticleInteractor]]))

(deftype ArticleInteractorImpl [repository]
  ArticleInteractor
  (create [_ article] (save repository article))
  (update [_ article] (modify repository article))
  (get [_ id] (find repository id))
  (is_publish [_ id] (check_publish repository id))
  (publish [_ id] (set_publish repository id))
  (un_publish [_ id] (set_un_publish repository id)))

(defn articleInteractor [repository]
  (ArticleInteractorImpl. repository))
