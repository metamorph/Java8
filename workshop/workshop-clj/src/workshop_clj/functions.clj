(ns workshop-clj.functions)

(defn negate 
  "Return a function that will swap the return value of the provided function (true -> false)" 
  [f] 
  (complement f))

(defn flip 
  "Returns a new function taking two argument in the flipped order
   of 'f'." 
  [f] 
  (fn [a b] (f b a)))

(defn compose
  "Return a function that is a composition of the two provided funcs"
  [f1 f2]
  (comp f2 f1))

