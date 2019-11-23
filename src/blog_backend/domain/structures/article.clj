(ns blog-backend.domain.structures.article)

(defrecord Article [^Integer id
                    ^String title
                    ^String body
                    ^String created_at
                    ^String updated_at
                    ^String url
                    ^String repository_url
                    ^Integer article_id])
