#!/usr/bin/env bb
(ns dev
  (:require [babashka.process :refer [$] :as p]))

(defn garden-process
  []
  ^{:out :inherit} ($ lein garden auto))

(defn repl-process
  []
  ^{:out :inherit} ($ lein with-profile dev do shadow watch app))

(defn run-dev!
  []
  (let [garden (garden-process)
         repl (repl-process)]
     (try
       (println "Press Q to quit...")
       (flush)
       (read-line)
       nil
       (finally
         (println "Closing garden watch")
         (println @(p/destroy garden))
         (println "Closing repl")
         (println @(p/destroy repl))))))

(defn- compile-resume
  []
  (println "Compiling resume")
  (p/check (p/process '[lein shadow release app] {:out :inherit})))

(defn export!
  []
  (compile-resume)
  (println "Exporting PDF")
  (p/check (p/process '[node bin/export-pdf.js] {:out :inherit}))
  (println "Done!"))

(defn -main
  [& [command]]
  (case command
    "export" (export!)
    (run-dev!)))

(when (System/getProperty "babashka.file")
  (apply -main *command-line-args*))
