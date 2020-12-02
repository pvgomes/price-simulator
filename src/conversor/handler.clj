(ns conversor.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [conversor.exchange :as exchange]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/credit-card" []
    (-> (exchange/raw-quotation "BRL" "USD")
        (exchange/format-response "USD" 1)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))