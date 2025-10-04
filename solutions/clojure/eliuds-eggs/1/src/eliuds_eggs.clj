(ns eliuds-eggs
  (:require [clojure.string :as str]))

(defn egg-count
  "Returns the number of 1 bits in the binary representation of the given number."
  [number]
  (if (zero? number)
    0
    (+ (mod number 2) (egg-count (quot number 2))))
  )