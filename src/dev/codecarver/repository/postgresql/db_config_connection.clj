(ns dev.codecarver.repository.postgresql.db-config-connection
  (:require [dev.codecarver.util.env :refer [get-env]]))

(def db
  {:dbtype   "postgres"
   :dbname   (get-env :POSTGRES_DB "blog")
   :user     (get-env :POSTGRES_USER "admin")
   :password (get-env :POSTGRES_PASSWORD "admin")
   :port     (get-env :POSTGRES_PORT 5432)})
