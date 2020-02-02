(ns dev.codecarver.repository.postgresql.article
  (:require [dev.codecarver.util.env :refer [get-env]])
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]
            [clojure.java.jdbc :as sql]))

(def ^:private db
  {:dbtype   "postgres"
   :dbname   (get-env :POSTGRES_DB "blog")
   :user     (get-env :POSTGRES_USER "admin")
   :password (get-env :POSTGRES_PASSWORD "admin")})

(deftype ArticleRepoPostgreSQL []
  ArticleRepository
  (save! [_ article] (sql/insert!
                       db
                       :article article))
  (update! [_ article] (sql/update!
                         db
                         :article article ["id = ?" (:id article)]))
  (find [_ id] (sql/get-by-id
                 db
                 :article id)))

(defn articleRepoPostgreSQL []
  (ArticleRepoPostgreSQL.))
