(ns waydm.core
  (:gen-class)
  (:require [compojure
             [core :refer [defroutes GET]]
             [route :refer [not-found resources]]]
            [hiccup.page :refer [html5 include-css include-js]]
            [mount.core :refer [defstate]]
            [org.httpkit.server :as httpkit]
            [taoensso.timbre :as log]
            [waydm.config :refer [app-config]]))

(defn head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   (include-css "/assets/site.css")])

(def mount-target
  [:div#app
   [:h3 "ClojureScript has not been compiled!"]
   [:p "please run "
    [:b "lein figwheel"]
    " in order to start the compiler"]])

(def loading-page
  (html5
   (head)
   [:body
    mount-target
    (include-js "/js/app.js")]))

(defn handler [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body loading-page})


(defroutes routes
  (GET "/test" handler)
  (GET "/" request loading-page)
  (resources "/"))

(defstate http-server
  :start (httpkit/run-server routes {:port (:server-port app-config)})
  :stop (http-server :timeout 100))

(defn restart-server []
  (mount.core/stop)
  (mount.core/start))

(defn -main[& args]
  (println "I'm loaded"))

