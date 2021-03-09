(ns resume.events
  (:require [re-frame.core :as re]
            [resume.db :as db]
            [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))
