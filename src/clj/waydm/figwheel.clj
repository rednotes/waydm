(ns waydm.figwheel
  (:require [figwheel-sidecar.repl-api :refer :all]))

(defn start-fw [& rest]
  (start-figwheel!)
  (if (not-empty rest)
    (cljs-repl)))


;; (start-fw)
