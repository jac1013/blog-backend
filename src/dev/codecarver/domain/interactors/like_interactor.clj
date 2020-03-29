(ns dev.codecarver.domain.interactors.like-interactor)

(defprotocol LikeInteractor
  "Handle like/plus_one operations in the system"
  (like! [_ like] "Creates a like/plus_one")
  (unlike! [_ id] "Deletes a like/plus_one by ID")
  (get-by-article [_ article-id] "Gets all likes for an article"))
