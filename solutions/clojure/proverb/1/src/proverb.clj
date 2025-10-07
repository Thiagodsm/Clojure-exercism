(ns proverb
   (:require [clojure.string :as str]))

(defn concat-rhymes [input-list]
  (let [first-word (first input-list)
        second-word (second input-list)]
    (str "For want of a " first-word " the " second-word " was lost." )))

(defn concat-last-rhyme [result-string first-word]
  (if (empty? result-string)
    (str "And all for the want of a " first-word ".")
    (str result-string "\nAnd all for the want of a " first-word ".")))

(defn recite
  ([input] (recite input [] (first input)))
  ([input result-lines first-word]
   (cond
     (empty? input) ""
     (= (count input) 1) (str/join "\n" (conj result-lines (str "And all for the want of a " first-word ".")))
     :else (let [line (concat-rhymes input)]
             (recur (rest input)
                    (conj result-lines line)
                    first-word)))))
