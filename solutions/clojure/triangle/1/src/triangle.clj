(ns triangle)

(defn validade-sides [a b c]
  (and (> a 0) (> b 0) (> c 0)))

(defn validade-two-sides-equal [a b c]
  (or (= a b) (= a c) (= b c)))

(defn validade-two-sides-sum [a b c]
  (and (> (+ a b) c) (> (+ a c) b) (> (+ b c) a)))

(defn valide-sides-different [a b c]
  (and (not= a b) (not= a c) (not= c b)))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  (and (= a b c) (validade-sides a b c))
  )

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  (and (validade-sides a b c) (validade-two-sides-equal a b c) (validade-two-sides-sum a b c))
  )

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
  (and (valide-sides-different a b c) (validade-two-sides-sum a b c))
  )
