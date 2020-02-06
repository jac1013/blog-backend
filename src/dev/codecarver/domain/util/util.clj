(ns dev.codecarver.domain.util.util
  (:require [validateur.validation :refer :all]))


(defn validate
  [options]
  (let [{:keys [validator to_validate action]} options
        validated (validator to_validate)]
    (if (valid? validated)
      (action)
      {:validation_error validated})))
