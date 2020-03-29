(ns dev.codecarver.repository.postgresql.like
  (:require [dev.codecarver.repository.postgresql.db-config-connection :refer [db]])
  (:require [dev.codecarver.domain.repository.like :refer [LikeRepository]]
            [clojure.java.jdbc :as jdbc]
            [dev.codecarver.domain.util.util :as util]))

(deftype ^:private Like [id article_id ip_address])

(def ^:private mapping-differences {:article-id "article_id" :ip-address "ip_address"})

(deftype ^:private LikeRepo []
  LikeRepository
  (save!
    [_ like]
    (util/dto->model (first (jdbc/insert!
             db
             :plus_one (util/model->dto like mapping-differences))) mapping-differences))
  (delete! [_ id]
    (jdbc/delete! db :plus_one ["id = ?" id]))
  (find-by-article-id [_ article-id]
    (util/dto->model (first (jdbc/find-by-keys db :plus_one {:article_id article-id})) mapping-differences)))


(defn likeRepoPostgreSQL []
  (LikeRepo.))
