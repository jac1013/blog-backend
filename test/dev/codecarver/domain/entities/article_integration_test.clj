(ns dev.codecarver.domain.entities.article-integration-test
  (:refer-clojure :exclude [update get list])
  (:require [clojure.core :as c])
  (:require [dev.codecarver.factory.article :refer [articleInteractor]])
  (:require [dev.codecarver.domain.interactors.article_interactor :refer :all])
  (:require [clojure.data.generators :as r])
  (:require [clojure.test :refer :all]))

(deftest ^:integration article-integration-test
  (testing "Should be able to create an article"
    (is true (= c/get (create (articleInteractor) {:title (r/string "a" (r/uniform 11 49)) :body (r/string "a" (r/uniform 50 500)) :is_publish false}) :id 1))))
