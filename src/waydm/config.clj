(ns waydm.config
  (:require [environ.core :refer [env]]))

(def db-uri (:database-url env))
