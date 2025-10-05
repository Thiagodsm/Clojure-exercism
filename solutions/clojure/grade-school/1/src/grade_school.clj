(ns grade-school)

(defn grade [school grade]  ;; <- arglist goes here
  (vec (get school grade [])) )

(defn add [school name grade]  ;; <- arglist goes here
  (update school grade
          (fn [students]
            (let [students (or students [])]
              (if (some #(= % name) students)
                students
                (conj students name))))))

(defn sorted [school]
  (into (sorted-map)
        (for [[g students] school]
          [g (vec (sort students))])))