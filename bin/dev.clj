#!/usr/bin/env bb
(ns dev
  (:require [babashka.process :refer [$] :as p]))

(defn garden-process
  []
  (p/process '[lein garden auto] {:out :inherit}))

(defn repl-process
  []
  (p/process '[lein watch] {:out :inherit}))

(defn -main
  [& _args]
  (let [garden (garden-process)
        repl (repl-process)]
    (println "Press Q to quit...")
    (flush)
    (read-line)
    (p/destroy garden)
    (p/destroy repl)))

(when (System/getProperty "babashka.file")
  (apply -main *command-line-args*))
