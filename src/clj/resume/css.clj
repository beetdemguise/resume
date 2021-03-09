(ns resume.css
  (:require [garden.def :refer [defstyles]]))

(def full {:height "100%" :width "100%"})
(def header-height 20)
(def sidebar-width 30)

(defn percent
  [num]
  (str num "%"))

(defn pixels
  [num]
  (str num "px"))

(defstyles screen
  [:* {:margin "auto"}]
  [:html full]
  [:body full]
  [:#app full]
  [:.resume full]
  [:body {:background "#66E"
          :color "blue"
          :margin 0}]
  [:.header {:background "#6E6"
             :height (percent header-height)
             :line-height 5}
   [:h1 {:display "inline"
         :padding (pixels 10)
         :padding-left (pixels 25)}]]
  [:.container {:height "85%"}]
  [:.sidebar {:background "#6EE"
              :width (percent sidebar-width)
              :height (percent (- 100 header-height))
              :float "left"}]
  [:.content {:background "#EE6"
              :width (percent (- 100 sidebar-width))
              :height (percent (- 100 header-height))
              :margin-left (percent sidebar-width)}])
