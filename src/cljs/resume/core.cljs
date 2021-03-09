(ns resume.core
  (:require [reagent.dom :as dom]
            [re-frame.core :as re]
            [resume.events :as events]
            [resume.views :as views]
            [resume.config :as config]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re/clear-subscription-cache!)
  (let [root (.getElementById js/document "app")]
    (dom/unmount-component-at-node root)
    (dom/render [views/resume] root)))

(defn init []
  (re/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
