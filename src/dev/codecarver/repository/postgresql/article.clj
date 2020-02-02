(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]
            [clojure.java.jdbc :as sql]))

(deftype ArticleRepoPostgreSQL []
  ArticleRepository
  (save! [_ article] (sql/insert!
                       "postgresql://admin:admin@localhost:5432/blog"
                       :article article))
  (update! [_ article] (sql/update!
                         "postgresql://admin:admin@localhost:5432/blog"
                         :article article ["id = ?" (:id article)]))
  (find [_ id] (sql/get-by-id
                    "postgresql://admin:admin@localhost:5432/blog"
                    :article id)))
