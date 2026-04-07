(ns nucleotide-count)

(def empy-dna {\A 0 \C 0 \G 0 \T 0})

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (cond (empty? strand) 0
        (not (contains? empy-dna nucleotide)) (throw (IllegalArgumentException. "Invalid nucleotide"))
        :else (count (filter #(= % nucleotide) strand))))

(defn nucleotide-counts [strand]
    (let [result (frequencies strand)]
      (merge empy-dna result)))