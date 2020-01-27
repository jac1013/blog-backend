(ns dev.codecarver.domain.interactors.implementations.article
  (:refer-clojure :exclude [update find get])
  (:require [dev.codecarver.repository.in-memory.article :refer [articleRepo]])
  (:require [dev.codecarver.domain.repository.article :refer [save
                                                              modify
                                                              find]])
  (:require [dev.codecarver.domain.interactors.article :refer [ArticleInteractor]])
  (:require [validateur.validation :refer :all]))

(def ^:private validator (validation-set
                           (presence-of :title)
                           (presence-of :body)
                           (length-of :title :within (range 10 50))))

(defn ^:private validate [action article] (if (valid? validator article)
                                            (action)
                                            (validator article)))

(deftype ArticleInteractorImpl [repository]
  ArticleInteractor
  (create [_ article] (validate (fn [] (save repository article)) article))
  (update [_ article] (validate (fn [] (modify repository article)) article))
  (get [_ id] (find repository id))
  (is_publish [_ id] (modify repository id))
  (publish [_ id] (modify repository id))
  (un_publish [_ id] (modify repository id)))

(defn articleInteractor []
  (ArticleInteractorImpl. (articleRepo)))
