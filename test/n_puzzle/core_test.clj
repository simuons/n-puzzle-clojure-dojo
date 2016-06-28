(ns n-puzzle.core-test
  (:require [clojure.test :refer :all]
            [n-puzzle.core :refer :all]))

(deftest board-test
  (testing "create a board of a given enge size"
    (is (= (board 0) []))
    (is (= (board 1) []))
    (is (= (board 2) [[1 2]
                      [3 nil]]))
    (is (= (board 3) [[1 2 3]
                      [4 5 6]
                      [7 8 nil]]))))
