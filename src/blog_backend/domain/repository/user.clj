(ns blog-backend.domain.repository.user)

(defprotocol UserRepository
  "Represents the interaction with storage for user records"
  (create! [user] "Creates a user")
  (update_password! [id password] "Updates the password of a user"))
