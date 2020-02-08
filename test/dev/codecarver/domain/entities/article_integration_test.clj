(ns dev.codecarver.domain.entities.article-integration-test
  (:refer-clojure :exclude [update get list])
  (:require [clojure.core :as c])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer :all])
  (:require [clojure.test :refer :all]))

(deftest article-integration-test
  (testing "Should be able to create an article"
    (is true (= c/get (create (articleInteractor) {:title "longer than ten characters title" :body "He we have a body" :is_publish false}) :body "He we have a body"))))
