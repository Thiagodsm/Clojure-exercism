(ns raindrops)

(defn divisible-by [number divider]
  (zero? (mod number divider)))

(defn number-rain [divider]
  (cond (= divider 3) "Pling"
        (= divider 5) "Plang"
        (= divider 7) "Plong"
        :else (str divider)))

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
  (str (when (divisible-by num 3) (number-rain 3))
        (when (divisible-by num 5) (number-rain 5))
        (when (divisible-by num 7) (number-rain 7))
       (when (and (not (divisible-by num 3)) (not (divisible-by num 5)) (not (divisible-by num 7))) (str num)))
  )


