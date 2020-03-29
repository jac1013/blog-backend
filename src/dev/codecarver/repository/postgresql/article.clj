(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.repository.postgresql.db-config-connection :refer [db]])
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]
            [clojure.java.jdbc :as jdbc])
  (:require [clj-time.core]
            [clj-time.coerce]
            [dev.codecarver.domain.util.util :as util]))

(deftype ^:private Article [id title body created_at updated_at url repository_url is_publish article_id])

(def ^:private mapping-differences {:created "created_at" :updated "updated_at" :repository-url "repository_url" :publish? "is_publish" :article-id "article_id"})

(deftype ^:private ArticleRepoPostgreSQL []
  ArticleRepository
  (save!
    [_ article]
    (util/dto->model (first (jdbc/insert!
             db
             :article (util/model->dto article mapping-differences))) mapping-differences))
  (update!
    [this article]
    (let [id (:id article)]
      (jdbc/update!
       db
       :article (merge (util/model->dto article mapping-differences)
                       {:updated_at (clj-time.coerce/to-sql-time (clj-time.core/now))})
       ["id = ?" id]))
    (.find this (:id article)))
  (find
    [_ id]
    (util/dto->model (jdbc/get-by-id
     db
     :article id) mapping-differences))
  (find-all [_] (util/dtos->models (jdbc/query db ["SELECT * FROM article"] {:clojure.java.jdbc.spec/as-arrays? true}) mapping-differences)))

(defn articleRepoPostgreSQL []
  (ArticleRepoPostgreSQL.))
