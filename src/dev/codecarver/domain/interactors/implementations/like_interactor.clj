(ns dev.codecarver.domain.interactors.implementations.like-interactor
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [LikeInteractor]])
  (:require [dev.codecarver.domain.repository.like :as repo])
  (:require [taoensso.timbre :refer [error]])
  (:require [clojure.core.strint :refer [<<]]))

(defn- save! [repo like]
  (fn []
    (try
      (repo/save! repo like)
      (catch Exception e
        ((error (<< "There was a problem creating like \n ~{e}"))
         (throw e))))))

(defn- delete! [repo id]
  (fn []
    (try
      (repo/delete! repo id)
      (catch Exception e
        ((error (<< "There was a problem creating an like \n ~{e}"))
         (throw e))))))

(deftype ^:private Interactor [repository]
  LikeInteractor
  (like! [_ like] (save! repository like))
  (unlike! [_ id] (delete! repository id)))
