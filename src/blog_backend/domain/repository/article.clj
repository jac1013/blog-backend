(ns blog-backend.domain.repository.article)

(defprotocol ArticleRepository
  "Represents the interaction with a storage for article records"
  (createArticle [_ article] "Creates an article")
  (updateArticle [_] "Updates an article")
  (findArticle [_] "Finds an article by ID")
  (is_publish [_] "Whether or not an article is publish")
  (publish [_] "Publish an article")
  (un_publish [_] "Put down an article"))

(deftype ArticleRepo []
  ArticleRepository
  (createArticle [_ article] article)
  (updateArticle [this]
    ((this)))
  (findArticle [this]
    ((this)))
  (is_publish [this]
    ((this)))
  (publish [this]
    ((this)))
  (un_publish [this]
    ((this))))
