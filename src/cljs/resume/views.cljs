(ns resume.views
  (:require [clojure.set :as set]
            [clojure.string :as str]
            [re-frame.core :as re]
            [resume.subs :as subs]))

(defn main-panel []
  (let [name (re/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]]))

(defn heading
  []
  [:div.heading
   [:p.name.header @(re/subscribe [::subs/name])]
   [:p.title @(re/subscribe [::subs/title])]])

(defn degree
  [{:keys [icon name major university]}]
  (remove nil?
          [:div.degree {:key (or icon name)}
           (when icon [:img {:src icon :alt university :title university}])
           [:span name ", " major]]))

(defn education
  []
  [:div.degrees
   [:h2.header "Education"]
   (map degree @(re/subscribe [::subs/degrees]))])

(defn hobbies
  []
  [:div.hobbies
   [:h2.header "Tools"]
   (for [hobby @(re/subscribe [::subs/hobbies])]
     (let [{:keys [text href] :as attrs} (if (map? hobby) hobby {:text hobby})
           tag (if href :a :span)]
       [tag (assoc attrs
                   :key text
                   :target "_blank") text]))])

(defn buzzwords
  [{:keys [buzzwords]}]
  [:div.skills
   [:h2.header "Leadership & Training"]
   [:div.buzzy
    (for [buzz @(re/subscribe [::subs/buzzwords])]
      [:div [:span {:key buzz
                    :class (when (contains? buzzwords buzz) "highlighted")}
             buzz]])]])

(defn projects
  []
  [:div.projects
   [:h2.header "Projects"]
   [:div.container
    (for [{:keys [text href summary] :as _project} @(re/subscribe [::subs/projects])]
      [:div
       [:div [:a {:key text
                  :href href
                  :target "_blank"}
              text]]
       [:div.summary [:div summary]]])]])

(defn contact-method
  [{:keys [icon text href] :as attrs}]
  (let [tag (if href :a :span)]
    (into [] (remove nil?)
          [:div.method {:key (or icon text)}
           (when icon [icon])
           [tag (assoc attrs
                       :key text
                       :target "_blank")
            text]])))

(defn contact-info
  []
  [:div.contact
   [:div.methods
    (map contact-method @(re/subscribe [::subs/contact]))]])

(defn sidebar
  []
  [:div.sidebar
   [:img.portrait {:src "headshot.png"}]
   (contact-info)
   (education)
   (hobbies)])

(defn job-description
  [{:keys [job buzzwords]} i {:keys [title company team from to responsibilities]}]
  [:div.job {:key (str company team)}
   [:span.title title]
   [:p.description
    [:strong [:span.company company] " | " [:span.team team]]
    [:br]
    [:span.range [:span.from from] " - " [:span.to to]]]
   [:ul
    (map-indexed
     (fn [j {:keys [text tags]}]
       (let [key [i j]]
         [:li {:key key
               :class (when (or
                             ;; am i highlighted?
                             (= key job)
                             ;; is one of my tags highlighted?
                             (and (nil? job)
                                  (not-empty (set/intersection tags buzzwords))))
                        "highlighted")}
          text]))
      responsibilities)]])

(defn experience
  []
  [:div.experience
   [:h2.header "Experience"]
   (map-indexed (partial job-description @(re/subscribe [::subs/highlights])) @(re/subscribe [::subs/jobs]))])

(defn content
  []
  [:div.main
   (sidebar)
   [:div.content
    (buzzwords @(re/subscribe [::subs/highlights]))
    (projects)
    (experience)]])

(defn letter-content
  [{:keys [when greeting body]
    {:keys [name contact-methods]} :from}]
  [:div.main.letter
   [:div.time when]
   [:div.header.greeting greeting]
   (for [part (str/split body #"\n\n")]
     [:div.paragraph part])
   [:div.salutation
    [:div.name name]
    [:div.contact
     [:div.methods
      (map contact-method contact-methods)]]]])

(defn resume
  []
  [:div.resume
   (heading)
   (if-let [letter @(re/subscribe [::subs/letter])]
     (letter-content letter)
     (content))])
