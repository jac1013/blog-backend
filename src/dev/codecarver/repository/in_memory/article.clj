(ns dev.codecarver.repository.in-memory.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(def articles (atom {}))
(def counter (atom 0))

(defn save! [article]
  (let [id (str (swap! counter inc))]
    (swap! articles assoc id (assoc article :id id))
    (get @articles id)))

(defn modify! [article]
  (let [id (get article :id) db_article (get @articles id)]
    (swap! articles assoc id (merge db_article article))
    (get @articles id)))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] (save! article))
  (modify [_ article] (modify! article))
  (find [_ id] (get @articles id))
  (is_publish [this id] (boolean (get (.find this id) :is_publish))))


(defn articleRepo []
  (ArticleRepo.))
