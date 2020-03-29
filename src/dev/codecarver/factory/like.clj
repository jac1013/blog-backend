(ns dev.codecarver.factory.like
  (:require [dev.codecarver.repository.postgresql.like :refer [likeRepoPostgreSQL]])
  (:require [dev.codecarver.domain.interactors.implementations.like-interactor :as impl])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]]))

(defn likeInteractor []
  (impl/likeInteractor (likeRepoPostgreSQL) (articleInteractor)))
