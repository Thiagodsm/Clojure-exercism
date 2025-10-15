(ns isogram
  (:require [clojure.string :as str]))

(defn isogram?
  "Returns true if the given string is an isogram;
  otherwise, it returns false."
  [s]
  (let [clean-word (str/lower-case (str/replace (str/replace s #"-" "") #" " ""))
        letters-group (vals (group-by identity clean-word))]
    (not (some #(> (count %) 1) letters-group))))