(ns dev.codecarver.domain.repository.article
  (:refer-clojure :exclude [update find]))

(defprotocol ArticleRepository
  "Represents the interaction with a storage for article records"
  (save [_ article] "Saves an article")
  (modify [_ article] "Modifies an article")
  (find [_ id] "Finds an article by ID"))
