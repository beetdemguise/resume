(ns resume.subs
  (:require [re-frame.core :as re]))

(re/reg-sub
 ::name
 (fn [db]
   (:name db)))
