(ns blog-backend.repository.postgresql.article
  (:import (blog_backend.domain.repository.article ArticleRepository)))

(deftype ArticleRepo []
  ArticleRepository
  (save [_ article] article)
  (modify [_ article] article)
  (find [_ id] id)
  (check_publish [this id] true)
  (set_publish [this id] "published")
  (set_un_publish [this id] "unpublished"))


(defn articleRepo []
  (ArticleRepo.))
