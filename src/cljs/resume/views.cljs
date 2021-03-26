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
  [{:keys [icon name major]}]
  [:div.degree2
   [:img {:src icon}]
   [:span name ", " major]])

(defn education
  []
  [:div.degrees
    [:h2.header "Education"]
    (map degree [{:name "B.S."
                  :icon "assets/gv.jpg"
                  :major "Computer Science"
                  :university "Grand Valley State University"}])])

(defn buzzwords
  []
  [:div.skills
   [:h2.header "Buzzwords"]
   [:div.buzzy
    (for [buzz ["clojure"
                "kafka"
                "kubernetes"
                "python"
                "docker"
                "elasticsearch"
                "rabbit"
                "postgres"
                "cassandra"
                "CI / CD"
                "git ops"
                "aws"
                "perl"
                "javascript"]]
      [:span buzz])]])

(defn contact-method
  [{:keys [icon text]}]
  [:div.method
   [icon]
   [:span text]])

(defn sidebar
  []
  [:div.sidebar
   [:img.portrait {:src "assets/guy.png"}]
   [:div.contact
    [:h2.header "Contact"]
    [:div.methods
     (map contact-method [{:icon :i.far.fa-envelope
                           :text "douglassdarin@gmail.com"}
                          {:icon :i.fas.fa-phone-alt
                           :text "(616) 312 - 9313"}
                          {:icon :i.fab.fa-github
                           :text "beetdemguise"}
                          {:icon :i.fab.fa-linkedin-in
                           :text "darindouglass"}])]]
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
   (for [job [{:title "Senior Software Engineer / Scrum Master"
               :company "Barracuda Networks"
               :team "Sonian"
               :from "Jan 2018"
               :to "now"
               :responsibilities
               ["Maintain, observe, and improve a distributed system that handles tens of millions of email per day"
                "Mentor junior developers through the learning curve of Clojure and our system"
                "Implement actionable, observable structured logging into a previously opaque legacy system"
                "Reimplemented previously-obtuse auditing service with well-defined, searchable user events"
                "Design and implement a streaming service for removing customer information from custom and encrypted files"
                "Removed expensive and complicated 3rd party rendering system with open-source tooling"
                "Lead the team through architectural decisions, sprints, and retrospectives"
                "Help coordinate bi-weekly movie/music/gaming nights for our entirely remote team"
                "Develop data-driven, hierarchical definitions for our services running in Kubernetes"
                "Coordinate with operations on 3rd party integrations (sensu, sumologic, ELK) and sunsetting of legacy deployment systems (Chef, EC2)"
                "Manage CI / CD operations via Jenkins, Github Actions, Artifactory, and flux"]}
              {:title "Senior Software Engineer"
               :company "Barracuda Networks"
               :team "Cloud Archiving"
               :from "Aug 2015"
               :to "Jan 2018"
               :responsibilities
               ["Simplified customer support experience with a python/Flask UI overlaying our system"
                "Improved performance of per-customer statistics gathering"
                "Helped maintain fleets of servers including Elasticsearch and Cassandra nodes"
                "Worked with operations to improve and update our Puppet code"
                "Reimplemented customer exports to provide better chunking, throughput, and checkpoint functionality"]}
              {:title "Software Engineer I"
               :company "Dematic"
               :team "Sort"
               :from "Jan 2014"
               :to "Aug 2015"
               :responsibilities
               ["Designed, commissioned, and tested extensive route-based, message-driven warehouse storage solutions"
                "Interfaced with 3rd party warehouse management systems and conveyor systems"
                "Optimized and refactord stored prodedures for use in multi-threaded operations"
                "Collaborated with customers through the design and implementation of their warehouse solution"]}]]
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
