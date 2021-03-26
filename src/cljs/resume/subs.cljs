(ns resume.subs
  (:require [re-frame.core :as re]))

(re/reg-sub
 ::name
 (fn [db]
   (println db)
   (-> db :_info :name)))

(re/reg-sub
 ::title
 (fn [db]
   (-> db :_info :title)))

(re/reg-sub
 ::contact
 (fn [db]
   (-> db :_info :contact-methods)))

(re/reg-sub
 ::hobbies
 (fn [db]
   (-> db :_info :hobbies)))

(re/reg-sub
 ::buzzwords
 (fn [db]
   (-> db :_info :buzzwords)))

(re/reg-sub
 ::degrees
 (fn [db]
   (-> db :_info :degrees)))

(re/reg-sub
 ::jobs
 (fn [db]
   (-> db :_info :jobs)))

(re/reg-sub
 ::highlights
 (fn [{:keys [highlights]}]
   highlights))
