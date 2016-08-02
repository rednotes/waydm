(ns waydm.db.mongo
  (:require [clj-time
             [core :as t]
             [local :as l]]
            [monger
             [collection :as mc]
             [core :as mg]]
            [waydm.config :refer [app-config]]
            [monger.joda-time]))

(defn connect [uri]
  (def conn (:conn (mg/connect-via-uri uri)))
  (def db (mg/get-db conn "rednotes")))

;; (connect db-uri)

;; (mg/disconnect conn)

;; quotations
(def quotations "quotations")

(def sample-quote {
                   ;; :text "I think that it's extraordinarily important that we in computer science keep fun in computing."
                   :text "I've been using Vim for about 2 years now, mostly because I can't figure out how to exit it."
                   :tags ["life", "vim"]
                   :url "https://news.ycombinator.com/item?id=9362839"})

(defn insert-quote [quote]
  (mc/insert db quotations quote))

;; (insert-quote sample-quote)

;; (def id (:_id (first (mc/find-maps db quotations))))
;; (mc/update-by-id db quotations id sample-quote)

;; (println (vec (mc/find-maps db quotations {} {:text true :_id false})))

;; links
(def links "links")

(def sample-link {:url "http://12factor.net/"
                  :text "Good ideas for writing web-apps"
                  :tags ["CS", "web", "before starting"]})

(defn insert-link [link]
  (mc/insert db links link))

;; (insert-link sample-link)
;; (mc/update-by-id db links lid sample-link)

;; (def lid (->> links
;;               (mc/find-maps db)
;;               (first)
;;               ;; (:_id)
;;               ))


(let [now (l/local-now)
      m (t/month now)
      y (t/year now)
      current-month (t/date-time y m)
      next-month (t/plus current-month (t/months 1))]
  (def main-goal

    {:start current-month
     :end   next-month
     :goal  "Create waydm service"
     :description
" * Create service with timeline and scroll back
 * Count-down timers for month/week/day goals
 * Currently work on(toggl integration)"
     })
  )


;; main-goal
;; (mc/insert db "goals" main-goal)
