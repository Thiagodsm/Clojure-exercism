(ns series)


(defn slices
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  (cond (and (> n (count s)) (not (empty? s))) (throw (IllegalArgumentException. "slice length cannot be greater than series length"))
        (= n 0) (throw (IllegalArgumentException. "slice length cannot be zero"))
        (< n 0) (throw (IllegalArgumentException. "slice length cannot be negative"))
        (empty? s) (throw (IllegalArgumentException. "series cannot be empty"))
        :else (map #(subs s % (+ % n)) (range 0 (- (count s) (dec n))))))
