(ns dev.codecarver.repository.in-memory.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(def articles (atom {}))
(def counter (atom 0))

(defn save! [article]
  (let [id (str (swap! counter inc))]
    (swap! articles assoc id (assoc article :id id))
    (get @articles id)))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] (save! article))
  (modify [_ article] (save! article))
  (find [_ id] (get @articles id)))


(defn articleRepo []
  (ArticleRepo.))
