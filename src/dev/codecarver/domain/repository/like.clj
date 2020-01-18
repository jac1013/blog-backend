(ns dev.codecarver.domain.repository.like)

(defprotocol LikeRepository
  "Represents the interaction with storage for like records"
  (create! [article_id ip_address] "Creates a like")
  (remove! [id] "Removes a like"))
