(ns dev.codecarver.api.controllers.article
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.api.util :refer [json-response]])
  (:require [taoensso.timbre :refer [warn]])
  (:require [clojure.core.strint :refer [<<]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer [create]]))

(defn create_article [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (create (articleInteractor) {:title "I have more than ten characters"
                                      :body "I'm just a body that's not empty"})})

(defn ^:private body-to-article [request]
  {:title (get-in request [:body "title"]) :body (get-in request [:body "body"])})

(defn create_article_ [request]
  (try
   (let [article (create (articleInteractor) (body-to-article request)) response (json-response)]
     (if (contains? article :validation_error)
       (assoc response :status 400 :body article)
       (assoc response :body article)))
   (catch Exception e
     (warn (<< "create_article request failed \n ~{e}"))
     (assoc (json-response) :status 500))))
