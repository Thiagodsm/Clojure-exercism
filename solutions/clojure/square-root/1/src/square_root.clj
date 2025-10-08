(ns square-root)

(defn square-root
  "Calculates a number's square root"
  [n]
  (if (= n 1)
    n
    (first (for [i (range 1 n)
          :when (= (/ n i) i)]
      i))))

