(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn- capitalize [s]
  (str (str/upper-case (subs s 0 1)) (subs s 1)))

(defn- kebab-to-camel [s]
  (let [words (str/split s #"-")
        [first & remaining] words]
    (apply str first (map capitalize remaining)))
  )

(defn clean [s]
  (-> s
    (str/replace " " "_")
    (str/replace #"[\u0000-\u001f|\u007f-\u009f]" "CTRL")
    (str/replace #"[^\p{L}_\-]" "")
    (str/replace #"[α-ω]" "")
    (kebab-to-camel)))
