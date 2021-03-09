(ns resume.core
  (:require [clj-htmltopdf.core :as pdf]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [hiccup.core :as html]
            [resume.html :as h])
  (:import [java.io PushbackReader])
  (:gen-class))

(def build-dir (io/file "build"))

(defn resume
  [resource]
  (let [data (-> resource
                 (io/resource)
                 (io/reader)
                 (PushbackReader.)
                 (edn/read))]
    (h/html
     (h/head)
     (h/body
      (h/header data)
      (h/main-content
       (h/left-bar
        (h/skills data)
        (h/buzzwords data))
       (h/job-history data))))))

(defn build!
  [build-type]
  (let [resume (resume "darin.edn")
        output (io/file build-dir (str "resume." (name build-type)))]
    (.mkdirs build-dir)
    (printf "Building %s to %s..." build-type (.getPath output))
    (case build-type
      :pdf (pdf/->pdf resume output)
      :html (spit output (html/html resume))
      (printf "unknown format %s\n" format))
    (println "Finished!")))

(defn -main
  [& build-types]
  (->> build-types
       (map edn/read-string)
       (map build!)
       (doall))
  (shutdown-agents))
