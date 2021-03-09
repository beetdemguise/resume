(ns resume.views
  (:require [re-frame.core :as re]
            [resume.subs :as subs]))

(defn main-panel []
  (let [name (re/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]]))

(defn flex-box
  [direction & tags]
  (let [tag (if (= :row direction)
              :div.flex.row
              :div.flex.column)]
    [tag
     tags]))

(defn header
  []
  [:div.header
   [:h1 "Darin Douglass"]])

(defn sidebar
  []
  [:div.sidebar
   [:h1 "sidebar"]])

(defn content
  []
  [:div.content
   [:h1 "content"]])

(defn resume
  []
  [:div.resume
   (header)
   (sidebar)
   (content)])
