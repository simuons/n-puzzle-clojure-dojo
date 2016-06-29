(ns n-puzzle.ui
  (:require [n-puzzle.core :refer :all])
  (:import [javax.swing JFrame]
           [java.awt.event KeyAdapter]
           [java.awt GridLayout Label])
  (:gen-class))

(defn- ->move [event]
  (condp = (.getKeyCode event)
    37 left
    38 up
    39 right
    40 down
    nil))

(defn -main [& args]
  (let [size (Integer/parseInt (first args))
        tiles (repeatedly (* size size) #(Label. "" Label/CENTER))
        frame (JFrame. (str size "-puzzle"))
        scramble (apply comp (repeatedly (Math/pow size 4) #(rand-nth [up right down left])))
        game (atom (scramble (board size)))
        draw #(doseq [[label value] (map vector tiles (flatten @game))] (.setText label (str value "")))]
    (doto frame
      (.setLayout (GridLayout. size size 2 2))
      (#(doseq [label tiles] (.add % label)))
      (.setSize 400 400)
      (.setResizable false)
      (.setVisible true)
      (.addKeyListener
        (proxy [KeyAdapter] []
          (keyPressed [e]
            (if-let [move (->move e)]
              (do
                (swap! game move)
                (draw)))))))
    (draw)))
