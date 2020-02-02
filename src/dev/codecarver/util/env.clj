(ns dev.codecarver.util.env
  (:require [dotenv :refer [env]]))

(defn get-env
  ([env_name] (get-env env_name ""))
  ([env_name default]
   (let [value (env env_name)]
     (if (empty? value)
       default
       value))))
