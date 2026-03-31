(ns darts)

(defn calculate-circle-distance [x y]
  (->> [x y]
       (map #(* % %))
       (reduce +)
       (Math/sqrt)))

(defn score
  "Calculates the score of a dart throw"
  [x y]
  (let [distance (calculate-circle-distance x y)]
    (cond (<= distance 1) 10
          (<= distance 5) 5
          (<= distance 10) 1
          :else 0)))
