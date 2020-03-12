(ns dev.codecarver.domain.interactors.implementations.article_interactor
  (:require [dev.codecarver.domain.entities.article :refer [validate]])
  (:require [dev.codecarver.domain.repository.article :as repo])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [ArticleInteractor]])
  (:require [taoensso.timbre :refer [error]])
  (:require [clojure.core.strint :refer [<<]]))

(defn- save! [repo article]
  (fn []
    (try
      (repo/save! repo article)
      (catch Exception e
        ((error (<< "There was a problem creating an article \n ~{e}"))
         (throw e))))))

(defn- update! [repo article]
  (fn []
    (try
      (repo/update! repo article)
      (catch Exception e
        ((error (<< "There was a problem updating an article ~{article} \n ~{e}"))
         (throw e))))))

(defn- find_ [repo id]
  (try
    (repo/find repo id)
    (catch Exception e
      ((error (<< "There was a problem finding an article \n ~{id} ~{e}"))
       (throw e)))))

(defn- find-all [repo]
  (try
    (repo/find-all repo)
    (catch Exception e
      ((error (<< "There was a problem finding all articles \n ~{e}"))
       (throw e)))))

(deftype ArticleInteractorImpl [repository]
  ArticleInteractor
  (create
    [_ article]
    (validate {:action      (save! repository article)
               :to_validate article}))
  (update_
    [_ article]
    (validate {:action      (update! repository article)
               :to_validate article}))
  (get_
    [_ id]
    (find_ repository id))
  (is_publish
    [this id]
    (boolean (get (.get_ this id) :is_publish)))
  (publish
    [this id]
    (.update_ this
              (assoc (.get_ this id) :is_publish true :url "this is a generated url")))
  (list_ [_] (find-all repository))
  (list_all_published [_] (filter (fn [a] (a :is_publish)) (find-all repository))))
