(ns demo.DemoClass
  (:require [xtdb.api :as xt])
  (:gen-class
   :init init
   :state state
   :methods [[start [] void]
             [stop [] void]
             [foo [Long] Long]
             [bar [Long] Long]]))

(defn -init []
  [[] {:node (atom nil)}])

(defn -start [this]
  (let [node (xt/start-node {})]
    (println "start" node)
    (reset! (:node (.state this))
            node)
    nil))

(defn -stop [this]
  (let [node @(:node (.state this))]
    (println "stop" node)
    (.close node)
    nil))

(defn -foo [this x]
  (println "foo from clojure class" this x)
  (inc x))

(defn -bar [this x]
  (println "bar from clojure class" this x)
  (dec x))
