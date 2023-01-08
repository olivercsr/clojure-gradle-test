(ns demo.DemoClass
  (:gen-class
   :methods [[foo [Long] Long]
             [bar [Long] Long]]))

(defn -foo [this x]
  (println "foo from clojure class" this x)
  (inc x))

(defn -bar [this x]
  (println "bar from clojure class" this x)
  (dec x))
