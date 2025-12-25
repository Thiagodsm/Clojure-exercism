(ns leap)

(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  (or (and (= (mod year 4) 0) (not= (mod year 100) 0)) (= (mod year 400) 0))
  )