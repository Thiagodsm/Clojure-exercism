(ns protein-translation
  (:require [clojure.string :as str]))

(def codons-map {"AUG" "Methionine"
                 "UUU" "Phenylalanine"
                 "UUC" "Phenylalanine"
                 "UUA" "Leucine"
                 "UUG" "Leucine"
                 "UCU" "Serine"
                 "UCC" "Serine"
                 "UCA" "Serine"
                 "UCG" "Serine"
                 "UAU" "Tyrosine"
                 "UAC" "Tyrosine"
                 "UGU" "Cysteine"
                 "UGC" "Cysteine"
                 "UGG" "Tryptophan"})

(def stops #{"UAA" "UAG" "UGA"})

(defn string-to-array3 [s]
  (for [i (range 0 (count s) 3)]
    (subs s i (min (+ i 3) (count s)))))

(defn translate-rna
  "Translates an RNA string into amino acids."
  [rna]
  (let [codons (string-to-array3 rna)
        droped (take-while #(not (stops %)) codons)
        invalid (some #(not (or (contains? codons-map %) (contains? stops %))) droped)]
    (cond (empty? rna) []
          invalid (throw (IllegalArgumentException. "Invalid codon"))
      (not (zero? (mod (count (str/join droped)) 3))) (throw (IllegalArgumentException. "Invalid codon"))
      :else (mapv #(get codons-map %) droped))))


