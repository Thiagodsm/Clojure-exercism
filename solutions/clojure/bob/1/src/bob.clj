(ns bob
  (:require [clojure.string :as str]))

(defn all-capital-letters? [s]
  (let [word-without-spaces (str/replace s #"\s+" "")]
    (= word-without-spaces (str/upper-case word-without-spaces))))

(defn has-at-least-one-letter? [s]
  (re-find #"[a-zA-Z]" s))

(defn response-for [s] ;; <- arglist goes here
  (cond (or (nil? s) (str/blank? s)) "Fine. Be that way!"
        (and (str/ends-with? s "?") (all-capital-letters? s) (has-at-least-one-letter? s)) "Calm down, I know what I'm doing!"
        (str/ends-with? (str/trim s) "?") "Sure."
        (and(all-capital-letters? s) (has-at-least-one-letter? s)) "Whoa, chill out!"
        :else "Whatever."))
