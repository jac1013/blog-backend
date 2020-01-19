(ns dev.codecarver.repository.in-memory.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] article)
  (modify [_ article] article)
  (find [_ id] id))


(defn articleRepo []
  (ArticleRepo.))
