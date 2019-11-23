(ns blog-backend.domain.structures.metadata)

(defrecord Metadata [^String title
                     ^String subtitle
                     ^String copyright logo_credit
                     ^Integer number_of_articles
                     ^Integer number_of_likes])
