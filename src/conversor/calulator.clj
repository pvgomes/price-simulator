(ns conversor.calulator)

(def spread 0.04M)

(def taxes 0.063M)

(defn get-credit-card-amount [final-value]
  (-> (+ (* final-value spread) final-value)
      (+ (* final-value taxes))
      (bigdec)))