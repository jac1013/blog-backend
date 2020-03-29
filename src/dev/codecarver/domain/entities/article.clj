(ns dev.codecarver.domain.entities.article
  (:require [validateur.validation :refer [validation-set
                                           presence-of
                                           length-of]])
  (:require [dev.codecarver.domain.util.util :as util]))

(defrecord Article [id title body created updated url repository-url publish? article-id])

(def ^:private validator (validation-set
                          (presence-of :title)
                          (presence-of :body)
                          (length-of :title :within (range 10 51))))

(defn validate [options]
  (util/validate (merge options {:validator validator})))
