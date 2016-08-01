(defproject waydm "0.1.0-SNAPSHOT"
  :description "Integration point for some services"
  :url "http://waydm.rednot.es"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.novemberain/monger "3.0.2"]
                 [environ "1.0.3"]
                 [clj-time "0.12.0"]]

  :main waydm.core)
