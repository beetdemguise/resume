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
   :header "#D7B5F459"
   :sidebar ""
   :content ""})

#_(defstyles screen
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

(defstyles screen
  [:* {:margin 0
       :font-family "'Raleway', sans-serif"}]
  [:body {:background (:body backgrounds)
          :color "#34495E"
          ;; :max-width (pixels 1100)
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
    [:.sidebar {:display "flex"
                :flex-direction "column"
                :background (:sidebar backgrounds)
                :padding (pixels standard-padding)
                :max-width (pixels portrait-width)
                ;; :width (pixels sidebar-width)
                ;; :height (percent 100)
                ;; :float "left"
                ;; :text-align "center"
                ;; :margin-top (pixels standard-padding)
                ;; :margin-bottom (pixels standard-padding)
                                        ;:border-right "2px solid #EEE"
                }
     [:.portrait {:height (pixels portrait-height)
                  :width (pixels portrait-width)
                  :padding-bottom (pixels standard-padding)}]
     [:.contact {:padding-bottom (pixels standard-padding)}
      [:.methods {:display "flex"
                  :flex-direction "column"
                  :justify-content "space-evenly"}
       [:.method {:display "flex"
                  :align-items "center"
                  :padding (pixels small-padding)}
        [:i {:margin-right (pixels standard-padding)}]]]]
     [:.skills {:display "flex"
                :flex-direction "column"
                :padding-bottom (pixels standard-padding)}
      [:.buzzy {:display "flex"
                :flex-flow "row wrap"}
       [:span {:flex-basis (percent 45)
               :padding (pixels smaller-padding)}]]]]
    [:.degrees {:padding-bottom (pixels standard-padding)}
     [:.degree2 {:display "flex"
                 :flex-direction "row"
                 :align-items "center"}
      [:img {:margin-right (pixels (dec standard-padding))
             :margin-left (pixels (inc smaller-padding))
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
       [:.description { ;;:padding (pixels smaller-padding)
                       }
        [:.company.team {:font-size (pixels 14)}]
        [:.from.to {:font-size (pixels 14)}]]]]
     #_[:.education {:display "flex"
                     :flex-direction "column"}
        [:.degree {:padding-bottom (pixels small-padding)}
         [:i {:margin-right (pixels standard-padding)}]
         [:span {:display "block"}]]]]]])
