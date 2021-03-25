(ns resume.css
  (:require [garden.def :refer [defstyles]]))

(defn percent
  [num]
  (str num "%"))

(defn pixels
  [num]
  (str num "px"))

(def full {:height (percent 100)
           :width (percent 100)})

(def standard-padding 25)
(def small-padding 10)
(def smaller-padding 5)

(def portrait-width 375)
(def portrait-height 415)
(def sidebar-width (+ portrait-width standard-padding standard-padding 5))

(def backgrounds
  {:body "#66E"
   :header "#6E6"
   :sidebar "#6EE"
   :content "#EE6"}
  #_{})

(defstyles screen
  [:* {:margin "auto"
       :font-family "'Raleway', sans-serif"}]
  [:html full]
  [:body full]
  [:#app full]
  [:.resume full]
  [:body {:background (:body backgrounds)
          :color "blue"
          :margin 0}]
  [:.header {:background (:header backgrounds)
             ;;:height (percent header-height)
             :text-align "center"
             ;;:line-height 5
             }
   [:.name {:font-size (pixels 85)
            :letter-spacing (pixels 10)
            :font-weight 400
            :padding (pixels standard-padding)
            :padding-bottom 0}]
   [:.title {:font-size (pixels 24)
             :letter-spacing (pixels 5)}]]
  [:.container {:height "85%"}]
  [:.sidebar {:background (:sidebar backgrounds)
              :width (pixels sidebar-width)
              :height (percent 100)
              :float "left"
              :text-align "center"
              ;; :margin-top (pixels standard-padding)
              ;; :margin-bottom (pixels standard-padding)
              ;:border-right "2px solid #EEE"
              }
   [:.portrait {:height (pixels portrait-height)
                :width (pixels portrait-width)
                :padding (pixels standard-padding)}]
   [:.contact {:padding (pixels small-padding)}]
   [:.skills {:padding (pixels small-padding)}]]
  [:.main {:height "100%"}
   [:.content {:margin-left (pixels sidebar-width)
               :background (:content backgrounds)
               ;; :width (percent (- 100 sidebar-width))
               :height (percent 100)
               :padding (pixels standard-padding)
               ;;:border-top "2px solid #EEE"
               }
    [:.experience {:padding-bottom (pixels small-padding)}
     [:.job {:padding (pixels small-padding)}
      [:.title {:font-size (pixels 24)}]
      [:.description {:padding (pixels smaller-padding)}
       [:.company.team {:font-size (pixels 14)}]
       [:.from.to {:font-size (pixels 14)}]]]]
    [:.education {:padding-top (pixels small-padding)}]]])
