(ns dev.codecarver.factory.like
  (:require [dev.codecarver.repository.postgresql.like :refer [likeRepoPostgreSQL]])
  (:require [dev.codecarver.domain.interactors.implementations.like-interactor :as impl]))

(defn likeInteractor []
  (impl/likeInteractor (likeRepoPostgreSQL)))
