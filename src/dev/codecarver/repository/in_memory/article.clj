(ns dev.codecarver.repository.in-memory.article
  (:refer-clojure :exclude [update])
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(def articles (atom {}))
(def counter (atom 0))

(defn save
  [article]
  (let [id (str (swap! counter inc))]
    (swap! articles assoc id (assoc article :id id))
    (get @articles id)))

(defn update
  [article]
  (let [id (get article :id) db_article (get @articles id)]
    (swap! articles assoc id (merge (select-keys db_article (keys article)) article))
    (get @articles id)))

(deftype ArticleRepo []
  ArticleRepository
  (save! [_ article] (save article))
  (update! [_ article] (update article))
  (find [_ id] (get @articles id)))


(defn articleRepo []
  (ArticleRepo.))
