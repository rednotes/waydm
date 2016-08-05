(ns waydm.core
  (:gen-class)
  (:require [compojure
             [core :refer [defroutes GET]]
             [route :refer [not-found resources]]]
            [mount.core :refer [defstate]]
            [org.httpkit.server :as httpkit]
            [taoensso.timbre :as log]
            [waydm.config :refer [app-config]]
            [waydm.figwheel :refer [start-fw]]
            [waydm.page :refer [page]]
            [ring.middleware.webjars :refer [wrap-webjars]]
            [ring.middleware.content-type :refer [wrap-content-type]]))



(defroutes routes
  (GET "/" request (page))
  (resources "/"))

(defn app []
  (-> #'routes
      wrap-webjars
      wrap-content-type
      ))

(defstate http-server
  :start (httpkit/run-server (app) {:port (:server-port app-config)})
  :stop (http-server :timeout 100))

(defn restart-server []
  (mount.core/stop)
  (mount.core/start))

(defn -main[& args]
  (mount.core/start))

(comment
  (restart-server)
  (start-fw)
  )
