(ns dev.codecarver.api.util)

(defn ^:private augment_response [body]
  (let [validation (get body :validation_error)]
    (if (nil? validation)
      {:status "Ok" :code 200 :result body}
      {:status "Bad Request" :code 400 :messages validation})))

(defn ^:private augment_response_error []
  {:status "Internal Server Error" :code 500})

(defn wrap-response [handler]
  (fn [request]
    (try
      (let [response (handler request) body (get response :body)]
        (assoc response :body (augment_response body)))
      (catch Exception e
        {:status 500 :body (augment_response_error)}))))
