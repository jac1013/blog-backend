(ns blog-backend.repository.postgresql.article
  (:import (blog_backend.domain.repository.article ArticleRepository)))

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
