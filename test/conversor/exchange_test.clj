(ns conversor.exchange-test
  (:require [clojure.test :refer :all]
            [conversor.exchange :as exchange]))

(deftest get-credit-card-amount-test
  (testing "test it get right format-quotation"
    (is (= "USD_BRL" (exchange/format-quotation "BRL" "USD")))))