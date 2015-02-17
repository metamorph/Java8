(ns workshop-clj.functions-test
  (:require [clojure.test :refer :all]
            [workshop-clj.functions :refer :all]))

(defn larger-than-5? "Check if a number is larger than 5" [n] (> n 5))
(defn str-length "Get the number of chars in a string" [s] (count s))
(defn subtract [a b] (- a b))

(deftest negate-test
  (testing "a predicate"
    (let [less-or-eql-to5? (negate larger-than-5?)]
      (is (less-or-eql-to5? 2))
      (is (less-or-eql-to5? 5))
      (is (not (less-or-eql-to5? 10))))))

(deftest flipped-test
  (testing "with subtraction"
    (let [flipped (flip subtract)]
      (is (= 6 (subtract 10 4)))
      (is (= -6 (flipped 10 4))))))

(deftest compose-test
  (let [longer-than-5? (compose str-length larger-than-5?)]
    (is (longer-than-5? "123456"))
    (is (not (longer-than-5? "abc")))))
