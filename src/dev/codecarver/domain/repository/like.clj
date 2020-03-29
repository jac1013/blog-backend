(ns dev.codecarver.domain.repository.like)

(defprotocol LikeRepository
  "Represents the interaction with storage for like records"
  (save! [article_id ip_address] "Creates a like")
  (delete! [id] "Removes a like"))
