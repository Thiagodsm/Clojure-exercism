(ns largest-series-product
  (:require [clojure.string :as str]))

(defn group-and-iterate [n collection]
  (partition n 1 collection))

(defn multipication [arr-str]
  (let [arr-num (map #(Integer/parseInt %) arr-str)]
    (reduce * arr-num)))

(defn largest-product
  "Returns the largest product of any consecutive digits of length span in the string s."
  [span s]
    (cond
      (< span 0) (throw (IllegalArgumentException. "span must not be negative"))
      (= span 0) 1
      (> span (count s)) (throw (IllegalArgumentException. "span must not exceed string length"))
      (nil? (re-matches #"\d+" s)) (throw (IllegalArgumentException. "digits input must only contain digits"))
      :else
      (let [colletion (map str s)
            n-collections (group-and-iterate span colletion)
            arr-of-multiples (map multipication n-collections)]
        (apply max arr-of-multiples))))

