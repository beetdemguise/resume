(ns resume.events
  (:require [re-frame.core :as re]
            [resume.db :as db]
            [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re/reg-event-fx
 :start-hover-job
 (fn [coeffects [_ job buzzwords]]
   (update-in coeffects [:db :highlights] merge {:job job :buzzwords buzzwords})))

(re/reg-event-fx
 :stop-hover-job
 (fn [coeffects [_ job]]
   (let [{hovered :job} (-> coeffects :db :highlights)]
     (if (= hovered job)
       (update-in coeffects [:db :highlights] merge {:job nil :buzzwords nil})
       coeffects))))

(re/reg-event-fx
 :start-hover-buzz
 (fn [coeffects [_ buzzword]]
   (assoc-in coeffects [:db :highlights :buzzwords] #{buzzword})))

(re/reg-event-fx
 :stop-hover-buzz
 (fn [coeffects [_ buzzword]]
   (let [{hovered :buzzwords} (-> coeffects :db :highlights)]
     (if (= hovered #{buzzword})
       (assoc-in coeffects [:db :highlights :buzzwords] nil)
       coeffects))))
