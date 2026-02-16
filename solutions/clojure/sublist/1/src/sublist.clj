(ns sublist)

(defn sub-sequence
  [target source]
  (some #{target} (partition (count target) 1 source)))

(defn set-target
  [coll1 coll2]
  (if (<= (count coll1) (count coll2))
    coll1
    coll2))

(defn set-source
  [coll1 coll2]
  (if (> (count coll1) (count coll2))
    coll1
    coll2))

(defn classify
  "Returns:
  :equal if coll1 equals coll2,
  :superlist if coll1 is a superlist of coll2,
  :sublist if coll1 is a sublist of coll2,

  If none of these conditions is true, it returns :unequal."
  [coll1 coll2]
  (let [target (set-target coll1 coll2)
        source (set-source coll1 coll2)
        is-superlist (and (> (count coll1) (count coll2)) (or (vector? coll1) (vector? coll2)))
        subsequence (sub-sequence target source)]
    (cond (= coll1 coll2) :equal
          (and (vector? subsequence) is-superlist) :superlist
          (and (vector? subsequence) (not is-superlist)) :sublist
          :else :unequal)))
