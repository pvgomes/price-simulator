(ns conversor.calculator-test
  (:require [clojure.test :refer :all]
            [conversor.calulator :as calculator]))

(deftest get-credit-card-amount-test
  (testing "on get credit card amount check if taxes is right"
    (is (< 5 (calculator/get-credit-card-amount 5)))
    (is (= 228.8725M (calculator/get-credit-card-amount 207.50)))
    (is (= 19.3025M (calculator/get-credit-card-amount 17.50)))
    (is (= 1103M (calculator/get-credit-card-amount 1000)))))