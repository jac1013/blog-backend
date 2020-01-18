(ns dev.codecarver.domain.interactors.article
  (:refer-clojure :exclude [update find get])
  (:require [dev.codecarver.domain.repository.article :refer [save
                                                            modify
                                                            find
                                                            check_publish
                                                            set_publish
                                                            set_un_publish]]))

(defprotocol ArticleInteractor
  "Represents the interaction with a storage for article records"
  (create [_ article] "Creates an article")
  (update [_ article] "Updates an article")
  (get [_ id] "Gets an article by ID")
  (is_publish [_ id] "Whether or not an article is publish")
  (publish [_ id] "Publish an article")
  (un_publish [_ id] "Put down an article"))

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



