(ns resume.views
  (:require [clojure.set :as set]
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
  [:div.degree {:key icon}
   [:img {:src icon :alt university :title university}]
   [:span name ", " major]])

(defn education
  []
  [:div.degrees
   [:h2.header "Education"]
   (map degree @(re/subscribe [::subs/degrees]))])

(defn leadership
  []
  [:div.hobbies
   [:h2.header "Leadership"]
   (for [hobby @(re/subscribe [::subs/leadership])]
     (let [{:keys [text href] :as attrs} (if (map? hobby) hobby {:text hobby})
           tag (if href :a :span)]
       [tag (assoc attrs
                   :key text
                   :target "_blank") text]))])

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

(defn tools
  [{:keys [buzzwords]}]
  [:div.skills
   [:h2.header "Tools"]
   [:div.buzzy
    (for [buzz @(re/subscribe [::subs/hobbies])]
      [:div [:span {:key buzz
                    :class (when (contains? buzzwords buzz) "highlighted")}
             buzz]])]])

(defn contact-method
  [{:keys [icon text href] :as attrs}]
  (let [tag (if href :a :span)]
    [:div.method {:key icon}
     [icon]
     [tag (assoc attrs
                 :key text
                 :target "_blank")
      text]]))

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
   #_(leadership)
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
    (experience)]])

(defn resume
  []
  [:div.resume
   (heading)
   (content)])
