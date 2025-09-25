(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [base (* speed 221)]
    (cond (= speed 0) 0
          (<= 1 speed 4) base
          (<= 5 speed 8) (* base 0.9)
          (= speed 9) (* base 0.8)
          (= speed 10) (* base 0.77)
          :else 0)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (-> speed
      (production-rate)
      (/ 60)
      (int)))
