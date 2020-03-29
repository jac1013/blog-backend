(ns dev.codecarver.domain.interactors.like-integration-test
  (:require [clojure.test :refer :all])
  (:require [dev.codecarver.factory.like :refer [likeInteractor]])
  (:require [dev.codecarver.domain.interactors.like-interactor :refer [like! unlike! get-by-article]])
  (:require [dev.codecarver.repository.postgresql.like :refer [likeRepoPostgreSQL]])
  (:require [dev.codecarver.domain.repository.like :as repo]))

(defn- mock-like []
  {:article-id 1 :ip-address "192.168.1.100"})

(defn- get-likes-for-article []
  (get-by-article (likeInteractor) 1))

(deftest ^:integration like-integration-test
  (testing "Should be able to create a like on an article"
    (is (= 1 (get (like! (likeInteractor) (mock-like)) :id))))
  (testing "Should be able to remove a like from an article"
    (is (= true (empty? (let [_ (unlike! (likeInteractor) 1)] (get-likes-for-article)))))))
