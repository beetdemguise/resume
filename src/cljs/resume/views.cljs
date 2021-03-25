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

(defn heading
  []
  [:div.heading
   [:p.name.header "Darin Douglass"]
   [:p.title "Software Engineer"]])

(defn degree
  [{:keys [name major university]}]
  [:div.degree
   [:span name]
   [:span major]
   [:span university]])

(defn education
  []
  [:div.education
   [:h2.header "Education"]
   (map degree [{:name "Bachelor of Science"
                 :major "Computer Science"
                 :university "Grand Valley State University"}
                {:name "Masters of Arts"
                 :major "Data Science"
                 :university "Western Michigan University"}])])

(defn buzzwords
  []
  [:div.skills
   [:h2.header "Buzzwords"]
   [:div.buzzy
    (for [buzz ["clojure"
                "kafka"
                "kubernetes"
                "docker"
                "database"
                "streaming"
                "python"
                "perl"
                "javascript"]]
      [:span buzz])]])

(defn sidebar
  []
  [:div.sidebar
   [:img.portrait
    {:src "assets/guy.png"}]
   [:div.contact
    [:h2.header"Contact"]
    [:div.methods
     [:span [:a {:href "https://google.com"} "douglassdarin@gmail.com"]]
     [:span "(616) 312 - 9313"]
     [:span "Mattawan, MI"]]]
   (buzzwords)
   (education)])

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
   [:h1.header "Experience"]
   (for [job [{:title "Senior Software Engineer"
               :company "Barracuda Networks"
               :team "Sonian"
               :from "Jan 2018"
               :to "now"
               :responsibilities ["one" "two" "three"]}
              {:title "Senior Software Engineer"
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

(defn content
  []
  [:div.main
   (sidebar)
   [:div.content
    (experience)]])

(defn resume
  []
  [:div.resume
   (heading)
   (content)])
