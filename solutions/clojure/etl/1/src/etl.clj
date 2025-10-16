(ns etl
  (:require [clojure.string :as str]))

(defn transform
  [source]
  (let [initial {}
        result (for [[key arr] source
                     element arr]
                 (assoc initial (str/lower-case element) key))]
    (apply merge result)))