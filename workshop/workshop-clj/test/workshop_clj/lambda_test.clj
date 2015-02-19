(ns workshop-clj.lambda-test
  (:require [clojure.test :refer :all]
            [workshop-clj.model :as model]
            [workshop-clj.lambda :refer :all]))

(deftest lambda-test
  (testing "email-function"
    (let [person (model/create-person "Nils" 33 "foo@bar.com")
          email-getter (create-email-getter)]  
    (is (= "foo@bar.com" (email-getter person)))))
  (testing "email-function-for-null"
    (is (= "unknown@domain.com" 
           ((create-email-getter-with-nil) (model/create-person "Nils" 33 nil))))
    (is (= "abc@bbb.com"
           ((create-email-getter-with-nil) (model/create-person "Nils" 33 "abc@bbb.com")))))
  (testing "extract-age"
    (is (= "89;35;" (test1 model/people)))))

