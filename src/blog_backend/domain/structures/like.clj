(ns blog-backend.domain.structures.like)

(defrecord Like [^Integer id
                 ^Integer article_id
                 ^String ip_address])
