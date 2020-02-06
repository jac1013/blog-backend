(ns dev.codecarver.domain.entities.article)

(defrecord Article [id title body created_at updated_at url repository_url is_publish article_id])
