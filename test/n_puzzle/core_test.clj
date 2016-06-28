(ns n-puzzle.core-test
  (:require [clojure.test :refer :all]
            [n-puzzle.core :refer :all]))

(deftest board-test
  (testing "create a board of a given enge size"
    (are [edge-size expected-board]
      (= (board edge-size) expected-board)
      0 []
      1 []
      2 [[1 2]
         [3 nil]]
      3 [[1 2 3]
         [4 5 6]
         [7 8 nil]])))

(deftest moves-test
  (testing "move right to empty slot"
    (are [given-board expected-board]
      (= (right given-board) expected-board)
      [[0 nil] [0 0]] [[nil 0] [0 0]]
      [[0 0] [0 nil]] [[0 0] [nil 0]]))
  (testing "move right a right most tile leaves board as is"
    (are [board]
      (= (right board) board)
      [[nil 0] [0 0]]
      [[0 0] [nil 0]])))
