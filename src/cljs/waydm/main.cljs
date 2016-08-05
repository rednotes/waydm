(ns waydm.main
  (:require [reagent.core :as r])
  (:require-macros [reagent.ratom :refer [reaction]]))

(enable-console-print!)

(defonce app-db (r/atom {:first "empty"}))


(defn heading []
  [:div.container
   [:h1 "Sample header"]])


(defn hello []
  (println (:first @app-db)))

(r/render [heading] (js/document.querySelector "#app"))
