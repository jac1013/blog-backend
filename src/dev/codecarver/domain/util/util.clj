(ns dev.codecarver.domain.util.util
  (:require [validateur.validation :refer [valid?]]))

(defn validate
  [options]
  (let [{:keys [validator to-validate action]} options
        validated (validator to-validate)]
    (if (valid? validated)
      (action)
      {:validation-error validated})))

(defn validation-error [message]
  {:validation-error message})

(defn model->dto [mapping-differences]
  (fn [model]
    (reduce-kv (fn [m k v] (if (contains? mapping-differences k)
                             (assoc m (keyword ((keyword k) mapping-differences)) ((keyword k) model))
                             (assoc m k v))) {} model)))

(defn dto->model [mapping-differences]
  (model->dto (reduce-kv #(assoc %1 (keyword %3) %2) {} mapping-differences)))

(defn dtos->models [mapping-differences]
  (fn [models]
    (map (dto->model mapping-differences) models)))
