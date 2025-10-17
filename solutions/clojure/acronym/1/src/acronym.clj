(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (let [aux-word (str/replace (str/upper-case phrase) #"[^a-zA-Z0-9\s']" " ")
        words (str/split aux-word #" ")
        letters (map #(first %) words)]
    (apply str letters)))
