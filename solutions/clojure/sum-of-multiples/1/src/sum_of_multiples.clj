(ns sum-of-multiples)

(defn multiples-smaller-than-limit [limit first-value]
  (keep #(when (zero? (mod % first-value)) %) (range first-value limit)))

(defn sum-of-multiples
  "Calculate the sum of multiples"
  [factors limit]
  (let [multiples (apply concat (map #(multiples-smaller-than-limit limit %) factors))]
    (reduce + (distinct multiples))))
