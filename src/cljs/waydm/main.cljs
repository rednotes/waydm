(ns waydm.main
  (:require [re-frame.core :refer [dispatch dispatch-sync reg-event-db]]
            [reagent.core :as r]
            [re-frame.subs :refer [reg-sub subscribe]]
            [re-frame.loggers :refer [console]]
            [re-frame.std-interceptors :refer [path]]))

(enable-console-print!)

(defonce timer-updater (js/setInterval #(dispatch [:timer (js/Date.)]) 1000))

(def init-state
  {:title "Some super title"
   :timer {:now (js/Date.)}})

(reg-event-db
 :init
 (fn [db _]
   (merge db init-state)))

(reg-event-db
 :timer
 (path [:timer :now])
 (fn [db [_ value]]
   value))

(reg-sub
 :timer
 (fn [db _]
   (-> db :timer :now)))


(defn heading []
  (let [time (subscribe [:timer])]
    (fn some-fun []
      [:div.container
       [:h1 "Sample header"]
       [:p (-> @time
               .toTimeString
               (clojure.string/split " ")
               first)]])))

(defn jumbo [text]
  [:div.jumbotron.text-xs-center
    [:h1 text]])

(defn app []
  [:div.container-fluid
   [:div.row.text-xs-center
    [heading]]
   [:div.row
    (for [i (range 3)]
      [:div.col-xs-4 [jumbo (str "text: " i)]])]])

(defn run []
  (dispatch-sync [:init])
  (r/render [app] (js/document.querySelector "#app")))

(run)
