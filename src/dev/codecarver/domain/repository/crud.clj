(ns dev.codecarver.domain.repository.crud)

(defprotocol CrudOperations
  "Basic Create/Read/Update/Delete"
  (save! [_ model] "Saves an article")
  (update! [_ model] "Modifies an article")
  (find [_ id] "Finds an article by ID")
  (delete! [_ id] "Finds an article by ID")
  (find-all  [_] "Finds all articles"))
