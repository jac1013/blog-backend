(ns dev.codecarver.domain.repository.article
  (:refer-clojure :exclude [update find]))

(defprotocol ArticleRepository
  "Represents the interaction with a storage for article records"
  (save [_ article] "Creates an article")
  (modify [_ article] "Updates an article")
  (find [_ id] "Finds an article by ID"))
