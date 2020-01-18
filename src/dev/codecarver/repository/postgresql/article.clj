(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] article)
  (modify [_ article] article)
  (find [_ id] id)
  (check_publish [_ _] true)
  (set_publish [_ _] "published")
  (set_un_publish [_ _] "unpublished"))


(defn articleRepo []
  (ArticleRepo.))
