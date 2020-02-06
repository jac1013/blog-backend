(ns dev.codecarver.domain.util.util
  (:require [validateur.validation :refer :all]))


(defn validate [options] (let [{:keys [validator to_validate action]} options]
                           (if (valid? validator to_validate)
                             (action)
                             (identity {:validation_error (validator to_validate)}))))
