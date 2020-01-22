(ns addfocus.subs
  (:require 
   [re-frame.core :as rf]))

(rf/reg-sub 
 :task/iu
 (fn [db [_ counter-id]]
   (filter #(and (:important %) (:urgent %)) (:tasks db))))

(rf/reg-sub 
 :task/i
 (fn [db [_ counter-id]]
   (filter #(and (:important %) (not (:urgent %))) (:tasks db))))

(rf/reg-sub 
 :task/u
 (fn [db [_ counter-id]]
   (filter #(and (not (:important %)) (:urgent %)) (:tasks db))))

(rf/reg-sub 
 :task/trivia
 (fn [db [_ counter-id]]
   (filter #(and (not (:important %)) (not (:urgent %))) (:tasks db))))


(rf/reg-sub
 :active-task
 (fn [db _]
   (first (filter #(= (:active-task db) (:id %)) (:tasks db)))))