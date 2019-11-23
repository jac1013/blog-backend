(ns blog-backend.domain.structures.user)

(defrecord User [^Integer id
                 ^String username
                 ^String password])
