(ns workshop-clj.model)

(defn create-person 
  "Create a person map"
  [name age email] 
  {:name name :email email :age age})

(def people 
  [(create-person "Jussi Karjalajnen" 89 "jussi@eisapeita.fi")
   (create-person "Urban Hult" 23 "urban@hult.se")
   (create-person "Jörgen Hult" 29 "jorgen@hult.se")
   (create-person "Anna Hult" 21 "anna@hult.se")
   (create-person "Åsa Råmson" 35 "slangpengarnaisjon@regeringen.se")])

