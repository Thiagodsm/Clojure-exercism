(ns pangram
  (:require [clojure.string :as str]))

(defn pangram?
  "Returns true if the given string is a pangram;
  otherwise, it returns false."
  [s]
  (let [result (str/replace (str/lower-case s) #"[^a-z']" "")]
    (= (count (distinct result)) 26)))
