(ns blog-backend.domain.repository.article
  (:require '[blog-backend.domain.structures.article])
  (:import  '[blog_backend.domain.structures.article Article]))

(defprotocol ArticleRepository
  "Represents the interaction with a storage for article records"
  (create! [^Article article ] "Creates an article")
  (update! [^Article article] "Updates an article")
  (find [id] "Finds an article by ID")
  (is_publish [id] "Whether or not an article is publish")
  (publish! [id] "Publish an article")
  (un_publish [id] "Put down an article"))
