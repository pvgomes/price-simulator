(ns conversor.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [conversor.exchange :refer [format-response get-quotation]])
  (:gen-class
   :methods [^:static [handler [String] String]]))

(def base-currency "BRL")

(def options-in
  [["-c" "--currency target currency" "currency that we must convert"
    :default "usd"]
   ["-a" "--amount AMOUNT" :default 1 :parse-fn #(Integer. %)]])

(defn -main
  "Money quotation main"
  [& args]
  (let [{:keys [currency amount]}
        (:options (parse-opts args options-in))]
    (-> (get-quotation base-currency currency)
        (format-response currency amount)
        (prn))))

(defn -handler [s]
  (let [currency "USD"
        amount (Integer. s)]
    (-> (get-quotation base-currency currency)
        (format-response currency amount)
        (str))))