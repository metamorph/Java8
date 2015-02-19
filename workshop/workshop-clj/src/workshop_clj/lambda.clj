(ns workshop-clj.lambda)

(defn create-email-getter [] :email)
(defn create-email-getter-with-nil [] 
  (let [nil-safe (fnil str "unknown@domain.com")]
    (fn [p] (-> p :email nil-safe))))
(defn test1 
  [people] 
  (let [age-filter #(> % 30)
        reducer #(str %1 %2 ";")]
    (reduce reducer "" (->> people (map :age) (filter age-filter)))))



