(ns dev.codecarver.api.controllers.like
  (:require [dev.codecarver.factory.like :refer [likeInteractor]])
  (:require [taoensso.timbre :refer [warn]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [like! unlike!]])
  (:require [dev.codecarver.api.util :refer [json-response]]))

(defn- get-article-id-from-params [request]
  (Integer/parseInt (get-in request [:params :articleId])))

(defn like [request]
  (try
    (let [like (like! (likeInteractor) (get-article-id-from-params request)) response (json-response)]
      (if (contains? like :validation-error)
        (assoc response :status 400 :body like)
        (assoc response :body like)))
    (catch Exception e
      (warn (<< "like request failed \n ~{e}"))
      (assoc (json-response) :status 500))))



(defn unlike [request]
  (try
    (let [_ (unlike! (likeInteractor) (get-article-id-from-params request)) response (json-response)]
      (assoc response :status 204))
    (catch Exception e
      (warn (<< "unlike request failed \n ~{e}"))
      (assoc (json-response) :status 500))))
