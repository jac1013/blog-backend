(ns dev.codecarver.domain.interactors.implementations.article
  (:refer-clojure :exclude [update find get])
  (:require [clojure.core :as c])
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.repository.article :refer [save
                                                              modify
                                                              find]])
  (:require [dev.codecarver.domain.interactors.article :refer [ArticleInteractor]])
  (:require [dev.codecarver.domain.util.util :refer :all])
  (:require [validateur.validation :refer :all]))

(def ^:private validator (validation-set
                           (presence-of :title)
                           (presence-of :body)
                           (length-of :title :within (range 10 50))))

(deftype ArticleInteractorImpl [repository]
  ArticleInteractor
  (create [_ article] (validate {:action (fn [] (save repository article)), :validator validator :to_validate article}))
  (update [_ article] (validate {:action (fn [] (modify repository article)), :validator validator :to_validate article}))
  (get [_ id] (find repository id))
  (is_publish [this id] (boolean (c/get (.get this id) :is_publish)))
  (publish [this id] (.update this (assoc (.get this id) :is_publish true :url "this is a generated url")))
  (un_publish [this id] (.update this (dissoc (assoc (.get this id) :is_publish false) :url))))

(defn articleInteractor []
  (ArticleInteractorImpl. (articleRepo)))
