(ns workshop-clj.functions)

(defn negate [f] (fn [v] (not (f v))))

(defn flip [f] (fn [a b] (f b a)))


