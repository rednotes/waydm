(ns waydm.figwheel
  (:require [figwheel-sidecar.repl-api :refer :all]))

(defn start-fw []
  (start-figwheel!)
  (cljs-repl))


(start-fw)
