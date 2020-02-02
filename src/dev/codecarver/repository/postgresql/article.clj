(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]))

(deftype ArticleRepoPostgreSQL []
  ArticleRepository
  (save! [this article])
  (update! [this article])
  (find [this id]))
