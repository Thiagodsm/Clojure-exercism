(ns collatz-conjecture)

(defn collatz
  "Returns the number of steps it takes to reach 1 according
  to the rules of the Collatz Conjecture."
  ([num] (collatz num 0))
  ([num steps]
  (if (= num 1)
    steps
    (if (even? num)
      (recur (/ num 2) (inc steps))
      (recur (+ (* num 3) 1) (inc steps))))))