(ns blog-backend.repository.postgresql.article
  (:import (blog_backend.domain.repository.article ArticleRepository)))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] article)
  (modify [_ article] article)
  (find [_ id] id)
  (is_publish [this]
    ((this)))
  (publish [this]
    ((this)))
  (un_publish [this]
    ((this))))


(defn articleRepo []
  (ArticleRepo.))
