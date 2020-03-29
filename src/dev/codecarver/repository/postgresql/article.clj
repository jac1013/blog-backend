(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.repository.postgresql.db-config-connection :refer [db]])
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]
            [clojure.java.jdbc :as jdbc])
  (:require [clj-time.core] [clj-time.coerce]))

(deftype ArticleRepoPostgreSQL []
  ArticleRepository
  (save!
    [_ article]
    (first (jdbc/insert!
            db
            :article article)))
  (update!
    [this article]
    (let [id (:id article)]
      (jdbc/update!
       db
       :article (merge article
                       {:updated_at (clj-time.coerce/to-sql-time (clj-time.core/now))})
       ["id = ?" id]))
    (.find this (:id article)))
  (find
    [_ id]
    (jdbc/get-by-id
     db
     :article id))
  (find-all [_] (jdbc/query db ["SELECT * FROM article"] {:clojure.java.jdbc.spec/as-arrays? true})))

(defn articleRepoPostgreSQL []
  (ArticleRepoPostgreSQL.))
