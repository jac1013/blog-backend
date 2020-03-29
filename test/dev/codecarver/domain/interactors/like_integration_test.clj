(ns dev.codecarver.domain.interactors.like-integration-test
  (:require [clojure.test :refer :all])
  (:require [dev.codecarver.factory.like :refer [likeInteractor]])
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [like! unlike!]]))

(defn- like []
  {:article_id 1 :ip_address "192.168.1.100"})

(deftest ^:integration like-integration-test
  (testing "Should be able to create a like on an article"
    (is (= 1 (get (like! (likeInteractor) (like)) :id))))
  (testing "Should be able to remove a like from an article"
    (is (= false (get (unlike! (likeInteractor) 1) :is_publish)))))
