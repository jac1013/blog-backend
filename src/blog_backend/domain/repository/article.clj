(ns blog-backend.domain.repository.article
  (:refer-clojure :exclude [find])
  (:require [blog-backend.domain.structures.article]
             [blog-backend.domain.structures.article :refer (map->Article)]))

(defprotocol ArticleRepository
  "Represents the interaction with a storage for article records"
  (create! [article] "Creates an article")
  (update! [article] "Updates an article")
  (find [id] "Finds an article by ID")
  (is_publish [id] "Whether or not an article is publish")
  (publish! [id] "Publish an article")
  (un_publish [id] "Put down an article"))

(map->Article {:id "hello"})
