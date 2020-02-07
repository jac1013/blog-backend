(ns dev.codecarver.domain.interactors.implementations.article
  (:refer-clojure :exclude [update find get])
  (:require [clojure.core :as core])
  (:require [dev.codecarver.domain.entities.article :refer [validate]])
  (:require [dev.codecarver.domain.repository.article :as repo])
  (:require [dev.codecarver.domain.interactors.article :refer [ArticleInteractor]]))


(deftype ArticleInteractorImpl [repository]
  ArticleInteractor
  (create [_ article] (validate {:action (fn [] (repo/save! repository article)) :to_validate article}))
  (update [_ article] (validate {:action (fn [] (repo/update! repository article)) :to_validate article}))
  (get [_ id] (repo/find repository id))
  (is_publish [this id] (boolean (core/get (.get this id) :is_publish)))
  (publish [this id] (.update this (assoc (.get this id) :is_publish true :url "this is a generated url")))
  (un_publish [this id] (.update this (dissoc (assoc (.get this id) :is_publish false) :url))))
