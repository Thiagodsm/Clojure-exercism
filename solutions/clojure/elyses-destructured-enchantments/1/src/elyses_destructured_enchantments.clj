(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck))


(defn second-card
  "Returns the second card from deck."
  [deck]
  (first (next deck)))

(defn swap [v i1 i2]
  (assoc v i2 (v i1) i1 (v i2)))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (swap deck 0 1))




(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (if (= (count deck ) 1) [(first deck ) nil] [(first deck) (rest deck)]))


(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if (> (count deck ) 0) (into [] (concat (vector (first deck)) face-cards (rest deck))) face-cards))

