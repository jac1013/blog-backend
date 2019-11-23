(ns blog-backend.domain.structures.article)

(defrecord Article [id title body created_at updated_at url repository_url article_id])
