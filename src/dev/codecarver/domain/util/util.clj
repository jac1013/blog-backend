(ns dev.codecarver.domain.util.util
  (:require [validateur.validation :refer :all]))


(defn validate [options] (let [action (get options :action)
                               validator (get options :validator)
                               to_validate (get options :to_validate)]
                           (if (valid? validator to_validate)
                             (action)
                             (identity {:validation_error (validator to_validate)}))))
