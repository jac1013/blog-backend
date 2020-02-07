(ns dev.codecarver.domain.entities.article
  (:require [validateur.validation :refer [validation-set
                                           presence-of
                                           length-of]])
  (:require [dev.codecarver.domain.util.util :as util]))

(def ^:private validator (validation-set
                           (presence-of :title)
                           (presence-of :body)
                           (length-of :title :within (range 10 50))))

(defrecord Article [id title body created_at updated_at url repository_url is_publish article_id])

(defn validate [options]
  (util/validate (merge options {:validator validator})))
