(ns armstrong-numbers)

(defn armstrong? [n]
  (let [digits (map #(Character/digit % 10) (str n))
        num-digits (count digits)
        total (reduce + 0N (map #(.pow (biginteger %) num-digits) digits))]
    (= (biginteger n) total)))