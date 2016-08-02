(ns waydm.core
  (:gen-class)
  (:require [taoensso.timbre :as log]
            [mount.core :refer [defstate]]))

(defstate http-server
  :start (log/info "test")
  :stop (+ 1 3))

(defn -main[& args]
  (println "I'm loaded"))

