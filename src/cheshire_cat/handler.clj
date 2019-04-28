(ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/cheshire-cat" []
       {:status 200
        :headers {"Content-Type" "application/json; charset=utf-8"}
        :body (json/generate-string
               {:name "Cheshire Cat"
                :status :grinning})})
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
