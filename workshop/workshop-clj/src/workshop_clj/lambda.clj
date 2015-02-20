(ns workshop-clj.lambda)

(defn create-email-getter [] :email)
;; (or (some->> f1 f2 f3) "default-value"
(defn create-email-getter-with-nil [] 
  (fn [p] (or (-> p :email) "unknown@domain.com")))
;; Compose - Join - Partial
(defn test1 
  [people] 
  (let [age-filter #(> % 30)
        reducer #(str %1 %2 ";")]
    (reduce reducer "" (->> people (map :age) (filter age-filter)))))



