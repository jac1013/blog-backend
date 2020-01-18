(ns dev.codecarver.domain.repository.article
  (:refer-clojure :exclude [update find]))

(defprotocol ArticleRepository
  "Represents the interaction with a storage for article records"
  (save [_ article] "Creates an article")
  (modify [_ article] "Updates an article")
  (find [_ id] "Finds an article by ID")
  (check_publish [_ id] "Whether or not an article is publish")
  (set_publish [_ id] "Publish an article")
  (set_un_publish [_ id] "Put down an article"))