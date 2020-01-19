(ns dev.codecarver.repository.in-memory.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(def articles (atom {}))
(defn save! [article]
  (swap! articles assoc (:id article) article))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] (save! article))
  (modify [_ article] (save! article))
  (find [_ id] (get @articles id)))


(defn articleRepo []
  (ArticleRepo.))
