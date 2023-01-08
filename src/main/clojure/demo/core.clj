(ns demo.core
  #_(:require [demo.DemoClass]))

(defn foo [x]
  (->> (range)
       (take-while #(<= % 0xFF))
       (remove #{1 2 3 4})
       (into []))
  (println "FOO" x)
  (inc x))

(defn bar [x]
  (println "BAR" x)
  (dec x))

#_(foo 123)

