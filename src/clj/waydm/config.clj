(ns waydm.config
  (:require [environ.core :refer [env]]
            [mount.core :refer [defstate]]))
(defn get-config []
  {:db-uri (:database-url env)
   :server-port (or (:server-port env) 8000)})

(defstate app-config
  :start (get-config))

;; (def db-uri (:database-url env))
