(ns dev.codecarver.repository.postgresql.article
  (:require [dotenv :refer [env]])
  (:require [dev.codecarver.domain.repository.article :refer [ArticleRepository]]
            [clojure.java.jdbc :as sql]))

(defn ^:private get_connection_url []
  (format "postgresql://%s:%s@%s:%s/%s"
          (env :POSTGRES_USER)
          (env :POSTGRES_PASSWORD)
          (env :POSTGRES_HOST)
          (env :POSTGRES_PORT)
          (env :POSTGRES_DB)))

(deftype ArticleRepoPostgreSQL []
  ArticleRepository
  (save! [_ article] (sql/insert!
                       (get_connection_url)
                       :article article))
  (update! [_ article] (sql/update!
                         (get_connection_url)
                         :article article ["id = ?" (:id article)]))
  (find [_ id] (sql/get-by-id
                 (get_connection_url)
                 :article id)))

(defn articleRepoPostgreSQL []
  (ArticleRepoPostgreSQL.))
