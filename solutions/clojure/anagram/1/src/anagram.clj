(ns anagram
  (:require [clojure.string :as str]))

(defn generate-map [word]
  (group-by identity (str/lower-case word)))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (let [target (generate-map word)]
    (filter #(and (not= (str/lower-case word) (str/lower-case %)) (= target (generate-map %))) prospect-list)))