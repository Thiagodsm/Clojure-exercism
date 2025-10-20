(ns rna-transcription
  (:require [clojure.string :as str]))

(defn transcription [origin]
  (cond (= origin "G") "C"
        (= origin "C") "G"
        (= origin "T") "A"
        (= origin "A") "U"
        :else ""))

(defn to-rna
  "Returns the RNA complement of the given DNA string sequence."
  [dna]
  (let [result (map #(transcription (str/upper-case %)) dna)]
    (apply str result)))
