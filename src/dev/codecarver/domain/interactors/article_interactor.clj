(ns dev.codecarver.domain.interactors.article_interactor)

(defprotocol ArticleInteractor
  "Use cases around Articles that the system accomplish"
  (create [_ article] "Creates an article")
  (update_ [_ article] "Updates an article")
  (get_ [_ id] "Gets an article by ID")
  (is_publish [_ id] "Whether or not an article is publish")
  (publish [_ id] "Publish an article")
  (exist? [_ id] "Returns whether an article exist or not")
  (list_ [_] "List all articles")
  (list_all_published [_] "List all published articles"))
