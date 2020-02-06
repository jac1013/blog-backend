(ns dev.codecarver.factory.article
  (:require [dev.codecarver.repository.postgresql.article :refer [articleRepoPostgreSQL]])
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.interactors.implementations.article :refer [->ArticleInteractorImpl]]))

(defn articleInteractor []
  (->ArticleInteractorImpl (articleRepoPostgreSQL)))
