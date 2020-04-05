(ns dev.codecarver.domain.interactors.implementations.like-interactor
  (:require [dev.codecarver.domain.entities.like :refer [validate]])
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [LikeInteractor]])
  (:require [dev.codecarver.domain.repository.like :as repo])
  (:require [dev.codecarver.domain.interactors.article-interactor :refer [exist?]])
  (:require [taoensso.timbre :refer [error]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [dev.codecarver.domain.util.util :as util]))

(defn- article-exist? [articleInteractor article-id]
  (exist? articleInteractor article-id))

(defn- save! [repository like]
  (try
    (repo/save! repository like)
    (catch Exception e
      ((error (<< "There was a problem creating like \n ~{e}"))
       (throw e)))))

(defn- save-with-validation [like repo articleRepo]
  (fn []
    (if (article-exist? articleRepo (:article-id like))
      (save! repo like)
      (util/validation-error (<< "article id ~{(:article-id like)} doesn't exist")))))

(defn- delete! [repository id]
  (try
    (repo/delete! repository id)
    (catch Exception e
      ((error (<< "There was a problem deleting a like ~{id} \n ~{e}"))
       (throw e)))))

(defn- find-by-article-id [repository article-id]
  (try
    (repo/find-by-article-id repository article-id)
    (catch Exception e
      ((error (<< "There was a problem finding likes for an article ~{article-id} \n ~{e}"))
       (throw e)))))

(deftype ^:private Interactor [repository articleRepo]
  LikeInteractor
  (like! [_ like] (validate {:action      (save-with-validation  like repository articleRepo)
                             :to-validate like}))
  (unlike! [_ id] (delete! repository id))
  (get-by-article [_ article-id] (find-by-article-id repository article-id)))

(defn likeInteractor [repository articleRepo]
  (->Interactor repository articleRepo))
