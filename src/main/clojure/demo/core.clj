(ns demo.core
  (:require #_[demo.DemoClass]
            [clojure.java.io :as io]
            [xtdb.api :as xt]))

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

(defn start-xtdb []
  (xt/start-node {}))

(defn stop-xtdb [node]
  (.close node))

#_(foo 123)

