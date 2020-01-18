(ns dev.codecarver.domain.repository.metadata)

(defprotocol MetadataRepository
  "Represent the interaction with storage for metadata of the blog record"
  (create! [metadata] "Creates metadata of the blog")
  (update! [metadata] "Updates metadata of the blog"))
