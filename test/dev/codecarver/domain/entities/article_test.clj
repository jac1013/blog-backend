(ns dev.codecarver.domain.entities.article_test
  (:require [clojure.test :refer :all]
            [dev.codecarver.domain.entities.article :refer :all])
  (:require [clojure.data.generators :as r]))

(deftest article-test
  (testing "Should return a map with error if title is greater than 50"
    (is (= true (contains? (validate {:action #() :to-validate {:title (r/string "a" 51) :body (r/string "qwer" 100)}}) :validation-error))))
  (testing "Should return a map with error if title is lower than 10"
    (is (= true (contains? (validate {:action #() :to-validate {:title (r/string "a" 8) :body (r/string "qwer" 100)}}) :validation-error))))
  (testing "Should return an empty function if title is between 10 and 50"
    (is (= true (empty? (validate {:action #() :to-validate {:title (r/string "a" 25) :body (r/string "qwer" 100)}})))))
  (testing "Should return a map with error if body is empty"
    (is (= true (contains? (validate {:action #() :to-validate {:title (r/string "a" 25)}}) :validation-error))))
  (testing "Should return a map with error if title is empty"
    (is (= true (contains? (validate {:action #() :to-validate {:body (r/string "qwer" 100)}}) :validation-error)))))
