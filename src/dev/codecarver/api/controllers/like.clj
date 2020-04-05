(ns dev.codecarver.api.controllers.like
  (:require [dev.codecarver.factory.like :refer [likeInteractor]])
  (:require [taoensso.timbre :refer [warn]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [like! unlike!]])
  (:require [dev.codecarver.api.util :refer [json-response]])
  (:require [dev.codecarver.domain.util.util :as util])
  (:require [validateur.validation :refer [validation-set
                                           presence-of
                                           length-of]]))

(defn- get-id-from-params [request]
  (Integer/parseInt (get-in request [:params :id])))

; TODO: validate info coming from request
(defn like [request]
  (try
    (let [like (like! (likeInteractor) (:body request)) response (json-response)]
      (if (contains? like :validation-error)
        (assoc response :status 400 :body like)
        (assoc response :body like)))
    (catch Exception e
      (warn (<< "like request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn unlike [id request]
  (try
    (let [_ (unlike! (likeInteractor) (get-id-from-params request)) response (json-response)]
      (assoc response :status 204))
    (catch Exception e
      (warn (<< "unlike request failed \n ~{e}"))
      (assoc (json-response) :status 500))))
