(ns dev.codecarver.factory.article
  (:require [dev.codecarver.repository.postgresql.article :refer [articleRepoPostgreSQL]]))

(defn articleInteractor []
  (ArticleInteractorImpl. (articleRepoPostgreSQL)))
