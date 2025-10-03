(ns strain)

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  (keep #(when (pred %) %) coll)
  )

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  (keep #(when (not (pred %)) %) coll)
  )
