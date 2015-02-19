(ns workshop-clj.lambda)

(defn create-email-getter [] :email)
(defn create-email-getter-with-nil [] 
  (let [nil-safe (fnil str "unknown@domain.com")]
    (fn [p] (-> p :email nil-safe))))


