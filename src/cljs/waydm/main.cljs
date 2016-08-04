(ns waydm.main
  (:require [reagent.core :as r]))

(enable-console-print!)

(defonce app-state (r/atom {:first "empty"}))

(defn heading []
  [:div.container
   [:h1 "Hello my dear friend"]
   [:h2 (:first @app-state)]])

(defn hello []
  (println (:first @app-state)))

(r/render [heading] (js/document.querySelector "#app"))
