(ns dev.codecarver.domain.interactors.article_interactor
  (:refer-clojure :exclude [update find get list]))

(defprotocol ArticleInteractor
  "Use cases around Articles that the system accomplish"
  (create [_ article] "Creates an article")
  (update [_ article] "Updates an article")
  (get [_ id] "Gets an article by ID")
  (is_publish [_ id] "Whether or not an article is publish")
  (publish [_ id] "Publish an article")
  (list [_] "List all articles"))
