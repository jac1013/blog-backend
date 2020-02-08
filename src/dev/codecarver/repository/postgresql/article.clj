(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.util.env :refer [get-env]])
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]
            [clojure.java.jdbc :as jdbc]))

(def ^:private db
  {:dbtype   "postgres"
   :dbname   (get-env :POSTGRES_DB "blog")
   :user     (get-env :POSTGRES_USER "admin")
   :password (get-env :POSTGRES_PASSWORD "admin")})

(deftype ArticleRepoPostgreSQL []
  ArticleRepository
  (save!
    [_ article]
    (jdbc/insert!
     db
     :article article))
  (update!
    [this article]
    (jdbc/with-db-transaction
      [tx db]
      (let [id (:id article)]
        (jdbc/update!
         tx
         :article article ["id = ?" id])
        (.find this id))))
  (find
    [_ id]
    (jdbc/get-by-id
     db
     :article id)))

(defn articleRepoPostgreSQL []
  (ArticleRepoPostgreSQL.))
