(ns n-puzzle.core)

(defn- swap [board p1 p2]
  (-> board
      (assoc-in p1 (get-in board p2))
      (assoc-in p2 (get-in board p1))))

(defn- hole [board]
  (first (filter #(<= 0 (last %)) (map-indexed #(vector %1 (.indexOf %2 nil)) board))))

(defn board [n] (partition n n [nil] (range 1 (* n n))))

(defn right [board]
  (let [[x y :as hole] (hole board)]
    (swap board hole [x (- y 1)])))
