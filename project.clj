(defproject waydm "0.1.0-SNAPSHOT"
  :description "Integration point for some services"
  :url "http://waydm.rednot.es"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.novemberain/monger "3.0.2"]
                 [environ "1.0.3"]
                 [clj-time "0.12.0"]
                 [org.clojure/clojurescript "1.9.93"]
                 [reagent "0.6.0-SNAPSHOT"]
                 [mount "0.1.11-SNAPSHOT"]
                 [com.taoensso/timbre "4.7.3"]
                 [http-kit "2.2.0"]
                 [hiccup "1.0.5"]
                 [compojure "1.5.1"]
                 [figwheel-sidecar "0.5.5-SNAPSHOT"]
                 [com.cemerick/piggieback "0.2.2-SNAPSHOT"]
                 [ring-webjars "0.1.1"]
                 [org.webjars/bootstrap "4.0.0-alpha.2"]]

  :plugins [[lein-cljsbuild "1.1.4-SNAPSHOT"]
            [lein-figwheel "0.5.5-SNAPSHOT"]]

  :figwheel {:css-dirs ["resources/public/assets"]}

  :source-paths ["src/clj" "src/cljc"]


  :cljsbuild {:builds {:dev
                       {:source-paths ["src/cljs" "src/cljc"]
                        :figwheel true
                        :compiler
                        {:main "waydm.main"
                         :optimizations :none
                         :asset-path "/js"
                         :output-to "resources/public/js/app.js"
                         :output-dir "resources/public/js/"
                         :pretty-print true
                         :source-map true}}}}

  :main waydm.core)
