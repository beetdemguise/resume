(defproject io.github.ddouglass/resume "SNAPSHOT"
  :description "My personal resume"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-htmltopdf "0.1"]
                 [garden "1.3.10"]
                 [hiccup "1.0.5"]]
  :aliases {"build" ["run" "-m" "resume.core"]})
