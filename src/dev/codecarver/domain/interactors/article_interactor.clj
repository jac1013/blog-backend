(ns dev.codecarver.domain.interactors.article_interactor)

(defprotocol ArticleInteractor
  "Use cases around Articles that the system accomplish"
  (create! [_ article] "Creates an article")
  (update! [_ article] "Updates an article")
  (get [_ id] "Gets an article by ID")
  (publish? [_ id] "Whether or not an article is publish")
  (publish [_ id] "Publish an article")
  (exist? [_ id] "Returns whether an article exist or not")
  (get-all [_] "List all articles")
  (get-published [_] "List all published articles"))
