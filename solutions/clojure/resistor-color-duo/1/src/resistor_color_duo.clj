(ns resistor-color-duo
  (:require [clojure.string :as str]))

(defn color-number [color]
    (cond (= color "black") 0
          (= color "brown") 1
          (= color "red") 2
          (= color "orange") 3
          (= color "yellow") 4
          (= color "green") 5
          (= color "blue") 6
          (= color "violet") 7
          (= color "grey") 8
          (= color "white") 9))

(defn resistor-value
  "Returns the resistor value based on the given colors"
  [colors]
  (Integer/parseInt (str (color-number (first colors)) (color-number (second colors)))))



