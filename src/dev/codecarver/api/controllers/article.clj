(ns dev.codecarver.api.controllers.article
  (:refer-clojure :exclude [update find get list])
  (:require [clojure.core :as c])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.api.util :refer [json-response]])
  (:require [taoensso.timbre :refer [warn]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [clojure.walk :refer [keywordize-keys]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create
                                                                          get
                                                                          update]]))

(defn create_article [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (create (articleInteractor) {:title "I have more than ten characters"
                                      :body "I'm just a body that's not empty"})})

(defn create_article [request]
  (try
    (let [article (create (articleInteractor) (c/get request :body)) response (json-response)]
      (if (contains? article :validation_error)
        (assoc response :status 400 :body article)
        (assoc response :body article)))
    (catch Exception e
      (warn (<< "create_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn ^:private get-id-from-params [request]
  (Integer/parseInt (get-in request [:params :id])))

(defn get_article [request]
  (try
    (let [article (get (articleInteractor) (get-id-from-params request)) response (json-response)]
      (assoc response :body (if (empty? article) {} article)))
    (catch Exception e
      (warn (<< "get_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn ^:private get-article-for-update [request]
  (merge (c/get request :body) {:id (get-id-from-params request)}))

(defn update_article [request]
  (try
    (let [article (update (articleInteractor) (get-article-for-update request)) response (json-response)]
      (if (contains? article :validation_error)
        (assoc response :status 400 :body article)
        (assoc response :body article)))
    (catch Exception e
      (warn (<< "create_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))
