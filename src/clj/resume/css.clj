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

(def standard-padding 20)
(def small-padding 10)
(def smaller-padding 5)

(def portrait-width 250)
(def portrait-height 250)
(def sidebar-width (+ portrait-width standard-padding standard-padding 5))

(def backgrounds
  {:body ""
   :header ""
   :sidebar ""
   :content ""})

(defstyles screen
  [:* {:margin 0
       :font-family "'Raleway', sans-serif"}]
  [:a {:text-decoration "none"
       :color "inherit"}]
  [:.highlighted {:font-weight "bold"
                  :color "#BF89ED"
                  :cursor "default"}]
  [:body {:background (:body backgrounds)
          :color "#34495E"
          :max-width (pixels 1100)
          :width (percent 100)
          :margin "auto"}]
  [:.header {:text-transform "uppercase"
             :letter-spacing (pixels 5)
             :padding-bottom (pixels small-padding)}]
  [:.resume {:display "flex"
             :flex-direction "column"
             :align-items "stretch"
             :justify-content "space-between"}
   [:.heading {:background (:header backgrounds)
               :text-align "center"
               :padding (pixels small-padding)}
    [:.name {:font-size (pixels 60)
             :font-weight 400}]
    [:.title {:font-size (pixels 24)
              :letter-spacing (pixels 5)}]]
   [:.main {:display "flex"
            :flex-direction "row"
            :align-items "stretch"
            :height "100%"}
    [:.skills {:display "flex"
               :flex-direction "column"
               :padding-bottom (pixels standard-padding)}
     [:.buzzy {:display "flex"
               :flex-flow "row wrap"}
      [:div {:width (pixels 135)}
       [:span {:font-size (pixels 14)}]]]]
    [:.hobbies {:padding-top (pixels standard-padding)}
     [:span :a {:display "block"
                :padding-bottom (pixels small-padding)}]]
    [:.sidebar {:display "flex"
                :flex-direction "column"
                :background (:sidebar backgrounds)
                :padding (pixels standard-padding)
                :max-width (pixels portrait-width)}
     [:.portrait {:height (pixels portrait-height)
                  :width (pixels portrait-width)
                  :border-radius (percent 50)
                  :padding-bottom (pixels standard-padding)}]
     [:.contact {:padding-bottom (pixels standard-padding)}
      [:.methods {:display "flex"
                  :flex-direction "column"
                  :justify-content "space-evenly"}
       [:.method {:display "flex"
                  :align-items "center"
                  :padding (pixels small-padding)}
        [:i {:margin-right (pixels standard-padding)}]]]]]
    [:.degrees {:padding-top (pixels standard-padding)
                :padding-bottom (pixels standard-padding)}
     [:.degree {:display "flex"
                :flex-direction "row"
                :align-items "center"}
      [:img {:margin-right (pixels smaller-padding)
             :margin-left (pixels smaller-padding)
             :height (pixels 25)}]
      [:span {:display "block"}]]]
    [:.content {:display "flex"
                :flex-direction "column"
                :justify-content "flex-start"
                :flex-grow 2
                :background (:content backgrounds)
                :padding (pixels standard-padding)}
     [:.experience {:padding-bottom (pixels standard-padding)}
      [:.job {:padding-bottom (pixels standard-padding)}
       [:.title {:font-size (pixels 24)}]
       [:.description
        [:.company.team {:font-size (pixels 14)}]
        [:.from.to {:font-size (pixels 14)}]]]]]]])
