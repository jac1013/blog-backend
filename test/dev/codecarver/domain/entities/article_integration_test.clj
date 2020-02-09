(ns dev.codecarver.domain.entities.article-integration-test
  (:refer-clojure :exclude [update get list])
  (:require [clojure.core :as c])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer :all])
  (:require [clojure.data.generators :as r])
  (:require [clojure.test :refer :all]))

(defn random-string [low high]
  (r/string "a" (r/uniform low high)))

(defn article []
  {:title (random-string 11 49) :body (random-string 50 500) :is_publish true})

(deftest ^:integration article-integration-test
  (testing "Should be able to create an article"
    (is (= true (c/get (create (articleInteractor) (article)) :is_publish))))
  (testing "Should be able to update an article"
    (is (= false (c/get (update (articleInteractor) (merge (article) {:id 1 :is_publish false})) :is_publish))))
  (testing "Should be able to get an article by ID"
    (is (= false (c/get (get (articleInteractor) 1) :is_publish))))
  (testing "Should be able to know if an article is publish"
    (is (= false (is_publish (articleInteractor) 1))))
  (testing "Should be able to publish an article"
    (is (= true (c/get (publish (articleInteractor) 1) :is_publish))))
  (testing "Should be able to list articles"
    (is (= 1 (count (filter (fn [value]
                              (= (:id value) 2)) (list (articleInteractor))))))))
