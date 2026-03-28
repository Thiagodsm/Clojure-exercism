(ns difference-of-squares)


(defn square-of-sum
  "Returns the square of the sum of the numbers up to the given number"
  [n]
  (let [sum (reduce + (range 1 (inc n)))]
     (* sum sum))
  )

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to the given number"
  [n]
  (let [numbers (range 1 (inc n))
        sqrt (map #(* % %) numbers)]
    (reduce + sqrt)))

(defn difference
  "Returns the difference between the square of the sum of numbers up to a given number and the sum of the squares of those numbers"
  [n]
  (- (square-of-sum n) (sum-of-squares n))
  )
