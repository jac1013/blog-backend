(ns dev.codecarver.repository.postgresql.like
  (:require [dev.codecarver.repository.postgresql.db-config-connection :refer [db]])
  (:require [dev.codecarver.domain.repository.like :refer [LikeRepository]]
            [clojure.java.jdbc :as jdbc]))

(deftype ^:private LikeRepo []
  LikeRepository
  (save! [_ article_id ip_address]
    first (jdbc/insert!
            db
            :plus_one {:article_id article_id :ip_address ip_address}))
  (delete! [_ id]
    (jdbc/delete! db :plus_one ["id = ?" id])))


(defn likeRepoPostgreSQL []
  (LikeRepo.))
