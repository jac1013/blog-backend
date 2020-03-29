(ns dev.codecarver.factory.like
  (:require [dev.codecarver.repository.postgresql.like :refer [likeRepoPostgreSQL]])
  (:require [dev.codecarver.domain.interactors.implementations.like-interactor :as impl])
  (:require [dev.codecarver.repository.postgresql.article :refer [articleRepoPostgreSQL]]))

(defn likeInteractor []
  (impl/likeInteractor (likeRepoPostgreSQL) (articleRepoPostgreSQL)))
