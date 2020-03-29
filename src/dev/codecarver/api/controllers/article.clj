(ns dev.codecarver.api.controllers.article
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.api.util :refer [json-response]])
  (:require [taoensso.timbre :refer [warn]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [clojure.walk :refer [keywordize-keys]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create!
                                                                          get
                                                                          update!
                                                                          get-published]]))
(defn create-article [request]
  (try
    (let [article (create! (articleInteractor) (:body request )) response (json-response)]
      (if (contains? article :validation_error)
        (assoc response :status 400 :body article)
        (assoc response :body article)))
    (catch Exception e
      (warn (<< "create_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn- get-id-from-params [request]
  (Integer/parseInt (get-in request [:params :id])))

(defn get-article [request]
  (try
    (let [article (get (articleInteractor) (get-id-from-params request)) response (json-response)]
      (assoc response :body (if (empty? article) {} article)))
    (catch Exception e
      (warn (<< "get_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn- get-article-for-update [request]
  (merge (:body request) {:id (get-id-from-params request)}))

(defn update-article [request]
  (try
    (let [article (update! (articleInteractor) (get-article-for-update request)) response (json-response)]
      (if (contains? article :validation_error)
        (assoc response :status 400 :body article)
        (assoc response :body article)))
    (catch Exception e
      (warn (<< "update_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn get-articles [_]
  (try
    (let [articles (get-published (articleInteractor)) response (json-response)]
      (assoc response :body (if (empty? articles) '[] articles)))
    (catch Exception e
      (warn (<< "list_articles request failed \n ~{e}"))
      (assoc (json-response) :status 500))))
