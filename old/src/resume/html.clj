(ns resume.html)

(defn html
  [& tags]
  [:html tags])

(defn head
  [& tags]
  [:head tags])

(defn body
  [& tags]
  [:body tags])

(defn header
  [{:keys [name]}]
  [:div [:span name]])

(defn main-content
  [& tags])

(defn left-bar
  [& tags])

(defn skills
  [data])

(defn buzzwords
  [data])

(defn job-history
  [data])
