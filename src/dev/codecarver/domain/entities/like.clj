(ns dev.codecarver.domain.entities.like
  (:require [validateur.validation :refer [validation-set
                                           presence-of
                                           length-of]])
  (:require [dev.codecarver.domain.util.util :as util]))

(defrecord Like [id article-id ip-address])

(def ^:private validator (validation-set
                          (presence-of :article-id)
                          (presence-of :ip-address)))

(defn validate [options]
  (util/validate (merge options {:validator validator})))
