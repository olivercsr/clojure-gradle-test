(ns demo.core)

(defn foo [x]
  (println "FOO" x)
  (inc x))

(defn bar [x]
  (println "BAR" x)
  (dec x))

#_(foo 123)

