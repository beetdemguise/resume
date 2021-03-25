(ns resume.views
  (:require [clojure.string :as str]
            [re-frame.core :as re]
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
   [:p.name (str/upper-case "Darin Douglass")]
   [:p.title "Software Engineer"]])

(defn sidebar
  []
  [:div.sidebar
   [:img.portrait {:src "https://designzzz.com/wp-content/uploads/2015/08/A-funny-stock-photo.jpg"}]
   [:div.contact
    [:h2 "Contact"]
    [:br]
    [:p "douglassdarin@gmail.com"]
    [:span "---"]
    [:p "(616) 312 - 9313"]
    [:span "---"]
    [:p "49762 Chase Way"]
    [:p "Mattawan, MI"]]
   [:div.skills
    [:h2 "Skills"]]])

(defn job-description
  [{:keys [title company team from to responsibilities]}]
  [:div.job
   [:span.title title]
   [:p.description
    [:strong [:span.company company] " / " [:span.team team]]
    [:br]
    [:span.range [:span.from from] " - " [:span.to to]]]
   [:ul
    (for [item responsibilities]
      [:li item])]])

(defn experience
  []
  [:div.experience
   [:h1 "Experience"]
   (for [job [{:title "Senior Sofware Engineer"
               :company "Barracuda Networks"
               :team "Sonian"
               :from "Jan 2018"
               :to "now"
               :responsibilities ["one" "two" "three"]}
              {:title "Senior Sofware Engineer"
               :company "Barracuda Networks"
               :team "Cloud Archiving"
               :from "Aug 2015"
               :to "Jan 2018"
               :responsibilities ["1" "2" "3"]}
              {:title "Something"
               :company "Dematic"
               :team "Sort"
               :from "Apr 2014"
               :to "Aug 2015"
               :responsibilities ["1" "2" "3"]}]]
     (job-description job))])

(defn education
  []
  [:div.education
   [:h1 "Education"]])

(defn content
  []
  [:div.main
   (header)
   [:div.content
    (experience)
    (education)]])

(defn resume
  []
  [:div.resume
   ;; (header)
   (sidebar)
   (content)])
