(ns dev.codecarver.domain.interactors.article
  (:refer-clojure :exclude [update find get]))

(defprotocol ArticleInteractor
  "Represents the interaction with a storage for article records"
  (create [_ article] "Creates an article")
  (update [_ article] "Updates an article")
  (get [_ id] "Gets an article by ID")
  (is_publish [_ id] "Whether or not an article is publish")
  (publish [_ id] "Publish an article")
  (un_publish [_ id] "Put down an article"))


