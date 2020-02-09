(ns dev.codecarver.domain.entities.article-integration-test
  (:refer-clojure :exclude [update get list])
  (:require [clojure.core :as c])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer :all])
  (:require [clojure.data.generators :as r])
  (:require [clojure.test :refer :all]))

(defn random-string [low high]
  (r/string "a" (r/uniform low high)))

(deftest ^:integration article-integration-test
  (testing "Should be able to create an article"
    (is 1 (c/get (create (articleInteractor) {:title (random-string 11 49) :body (random-string 50 500) :is_publish false}) :id)))
  (testing "Should be able to update an article"
    (is true (c/get (update (articleInteractor) {:title (random-string 11 49) :body (random-string 50 500) :is_publish true}) :is_publish)))
  (testing "Should be able to get an article by ID"
    (is true (c/get (get (articleInteractor) 1) :is_publish))))
