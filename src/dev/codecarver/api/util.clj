(ns dev.codecarver.api.util)

(defn- augment-response [body]
  (let [validation (get body :validation-error)]
    (if (nil? validation)
      {:status "Ok" :code 200 :result body}
      {:status "Bad Request" :code 400 :messages validation})))

(defn- augment-response-error []
  {:status "Internal Server Error" :code 500})

(defn wrap-response [handler]
  (fn [request]
    (try
      (let [response (handler request) body (get response :body)]
        (when-not (nil? response)
          (assoc response :body (augment-response body))))
      (catch Exception e
        {:status 500 :body (augment-response-error)}))))

(defn json-response []
  {:status 200
   :headers {"Content-Type" "application/json"}})
