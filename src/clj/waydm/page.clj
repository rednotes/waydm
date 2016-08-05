(ns waydm.page
  (:require [hiccup.page :refer [html5 include-css include-js]]))


(defn head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   (include-css "/assets/site.css")
   (include-css "/assets/bootstrap/css/bootstrap.min.css")])

(defn mount-target []
  [:div#app
   [:h3#loading "Loading please wait..."]])

(defn page []
  (html5
   (head)
   [:body
    (mount-target)
    (include-js "/js/app.js")]))
