(ns resistor-color
  (:require [clojure.string :as str]))
(def colors
  ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn color-code
  "Returns the numerical value associated with the given color"
  [color]
  (some (fn [[index value]] (when (= value (str/lower-case color)) index))
          (map-indexed vector colors)))