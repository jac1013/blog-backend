(ns dev.codecarver.domain.interactors.implementations.like-interactor
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [LikeInteractor]])
  (:require [dev.codecarver.domain.repository.like :as repo])
  (:require [taoensso.timbre :refer [error]])
  (:require [clojure.core.strint :refer [<<]]))

(defn- save! [repository like]
    (try
      (repo/save! repository like)
      (catch Exception e
        ((error (<< "There was a problem creating like \n ~{e}"))
         (throw e)))))

(defn- delete! [repository id]
    (try
      (repo/delete! repository id)
      (catch Exception e
        ((error (<< "There was a problem deleting a like ~{id} \n ~{e}"))
         (throw e)))))

(defn- find_by_article_id [repository article_id]
    (try
      (repo/find_by_article_id repository article_id)
      (catch Exception e
        ((error (<< "There was a problem finding likes for an article ~{article_id} \n ~{e}"))
         (throw e)))))

(deftype ^:private Interactor [repository]
  LikeInteractor
  (like! [_ like] (save! repository like))
  (unlike! [_ id] (delete! repository id))
  (get_for_article [_ article_id] (find_by_article_id repository article_id)))

(defn likeInteractor [repository]
  (->Interactor repository ))
