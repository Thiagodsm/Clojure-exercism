(ns word-count
  (:require [clojure.string :as str]))

(defn trim-apostrophes [word]
  (str/replace word #"^'+|'+$" ""))

(defn word-count [s]
  (let [s (str/lower-case s)
        s (str/replace s #"[^a-z0-9']+" " ")
        words (str/split s #"\s+")
        words (map trim-apostrophes words)
        words (remove str/blank? words)]
    (frequencies words)))