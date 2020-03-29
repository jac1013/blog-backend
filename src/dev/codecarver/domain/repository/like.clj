(ns dev.codecarver.domain.repository.like)

(defprotocol LikeRepository
  "Represents the interaction with storage for like records"
  (save! [_ like] "Creates a like")
  (delete! [_ id] "Removes a like"))
