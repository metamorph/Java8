(ns workshop-clj.functions-test
  (:require [clojure.test :refer :all]
            [workshop-clj.functions :refer :all]))


(deftest negate-test
  (defn larger-than-5? [n] (> n 5))

  (testing "a predicate"
    (let [less-or-eql-to5? (negate larger-than-5?)]
      (is (less-or-eql-to5? 2))
      (is (less-or-eql-to5? 5))
      (is (not (less-or-eql-to5? 10))))))

(deftest flipped-test
  (defn subtract [a b] (- a b))

  (testing "with subtraction"
    (let [flipped (flip subtract)]
      (is (= 6 (subtract 10 4)))
      (is (= -6 (flipped 10 4))))))
