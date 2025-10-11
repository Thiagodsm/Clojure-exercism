(ns hamming)

(defn distance
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (if (not= (count strand1) (count strand2))
    (throw (IllegalArgumentException. "strands must be of equal length"))
    (reduce + (map #(if (not= %1 %2) 1 0) strand1 strand2))))