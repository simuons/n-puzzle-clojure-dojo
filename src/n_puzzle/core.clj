(ns n-puzzle.core)

(defn board [n] (partition n n [nil] (range 1 (* n n))))
