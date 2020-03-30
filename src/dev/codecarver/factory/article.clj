(ns dev.codecarver.factory.article
  (:require [dev.codecarver.repository.postgresql.article :refer [articleRepoPostgreSQL]])
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.interactors.implementations.article-interactor :as impl]))

(defn articleInteractor []
  (impl/articleInteractor (articleRepoPostgreSQL)))
