(ns conversor.exchange
  (:require [cheshire.core :refer :all]
            [clj-http.client :as http-client]
            [conversor.calulator :refer [get-credit-card-amount]]))

(def api-key (System/getenv "API_KEY"))

(def api-url
  "https://free.currencyconverterapi.com/api/v6/convert")

(defn format-quotation [from to]
  (str to "_" from))

(defn format-response [quotation to value]
  (str value " " to " in credit card is equal than "
       (format "R$ %.2f" (* quotation value))))

(defn quote-by-quotation [quotation]
  (:body (http-client/get api-url
                          {:query-params {"q" quotation "apiKey" api-key}})))

(defn get-quotation [from to]
  (let [quotation (format-quotation from to)]
    (-> (quote-by-quotation quotation)
        (parse-string)
        (get-in ["results" quotation "val"])
        (get-credit-card-amount))))

