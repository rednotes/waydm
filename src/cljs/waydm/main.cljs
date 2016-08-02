(ns waydm.main
  (:require [reagent.core :as r]))

(enable-console-print!)

(def app-state (r/atom {:first "empty"}))

(defn heading []
  [:h1 "test"])

(defn hello []
  (println (:first @app-state)))

(r/render [heading] (js/document.querySelector "#app"))
(hello)
