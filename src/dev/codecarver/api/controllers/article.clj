(ns dev.codecarver.api.controllers.article
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.api.util :refer [json-response]])
  (:require [taoensso.timbre :refer [warn]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [clojure.walk :refer [keywordize-keys]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create
                                                                          get_
                                                                          update_
                                                                          list_all_published]]))
(defn create_article [request]
  (try
    (let [article (create (articleInteractor) (get request :body)) response (json-response)]
      (if (contains? article :validation_error)
        (assoc response :status 400 :body article)
        (assoc response :body article)))
    (catch Exception e
      (warn (<< "create_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn- get-id-from-params [request]
  (Integer/parseInt (get-in request [:params :id])))

(defn get_article [request]
  (try
    (let [article (get_ (articleInteractor) (get-id-from-params request)) response (json-response)]
      (assoc response :body (if (empty? article) {} article)))
    (catch Exception e
      (warn (<< "get_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn- get-article-for-update [request]
  (merge (get request :body) {:id (get-id-from-params request)}))

(defn update_article [request]
  (try
    (let [article (update_ (articleInteractor) (get-article-for-update request)) response (json-response)]
      (if (contains? article :validation_error)
        (assoc response :status 400 :body article)
        (assoc response :body article)))
    (catch Exception e
      (warn (<< "update_article request failed \n ~{e}"))
      (assoc (json-response) :status 500))))

(defn list_articles [_]
  (try
    (let [articles (list_all_published(articleInteractor)) response (json-response)]
      (assoc response :body (if (empty? articles) '[] articles)))
    (catch Exception e
      (warn (<< "list_articles request failed \n ~{e}"))
      (assoc (json-response) :status 500))))
