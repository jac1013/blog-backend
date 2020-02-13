(ns dev.codecarver.api.routes.article
  (:require [compojure.core :refer [defroutes wrap-routes GET POST PUT]])
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:require [ring.middleware.params :refer [wrap-params]])
  (:require [ring.middleware.json :refer [wrap-json-response wrap-json-body]])
  (:require [dev.codecarver.api.util :refer [wrap-response]])
  (:require [dev.codecarver.api.controllers.article :refer [get_article
                                                            create_article
                                                            update_article
                                                            list_articles]]))

(defroutes article_routes
  (->
   (GET "/article/:id" [] get_article)
   (wrap-defaults api-defaults)
   wrap-params
   (wrap-routes wrap-response)
   wrap-json-response)
  (->
   (PUT "/article/:id" [] update_article)
   (wrap-defaults api-defaults)
   (wrap-json-body {:keywords? true})
   (wrap-routes wrap-response)
   wrap-json-response)
  (->
   (POST "/article" [] create_article)
   (wrap-defaults api-defaults)
   (wrap-json-body {:keywords? true})
   (wrap-routes wrap-response)
   wrap-json-response)
  (->
   (GET "/articles" [] list_articles)
   (wrap-defaults api-defaults)
   wrap-params
   (wrap-routes wrap-response)
   wrap-json-response))
