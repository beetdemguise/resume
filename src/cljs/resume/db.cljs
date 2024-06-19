(ns resume.db)

(defn add-emacs
  "Preach it Brother."
  [responsibilities]
  (map #(update % :tags conj "emacs / cider") responsibilities))

(def default-db
  {:highlights {:job nil
                :buzzwords nil}
   :_info {:name "Melisa Overway"
           ;;:title "Principal Software Engineer"
           :contact-methods [{:icon :i.far.fa-envelope
                              :href "mailto:overwaym@reeths-puffer.org"
                              :text "overwaym@reeths-puffer.org"}
                             {:icon :i.fas.fa-phone
                              :text "(616) 638 - 5825"}]
           :degrees [{:name "B.A."
                      :icon "gv.jpg"
                      :major "Education / English Language Arts"
                      :university "Grand Valley State University"}
                     {:name "Master"
                      :icon "gv.jpg"
                      :major "Reading Instruction (partial)"
                      :university "Grand Valley State University"}]
           :projects [{:text "Empathy Podcasts" :href "https://galleries.vidflow.co/videos/fvd3a961"}
                      {:text "Long Walk to Water" :href "https://vimeo.com/957070061?share=copy"}]
           :hobbies ["Classkick"
                     "Google Suite"
                     "Padlet"
                     "Slido"
                     "Flipgrid"
                     "PearDeck"
                     "NewsEla"
                     "Epic"
                     "Calendly"]
           :buzzwords
           ["School Improvement Team"
            "Child Study Team"
            "PBL Leadership Group"
            "Capturing Kids' Hearts"
            "Project Based Learning (PBL)"
            "Lucy Calkins Columbia Workshop"
            "Brain Frames/Empower"
            "PBIS System of Support"
            "FAME: Formative Assessment"
            "CHAMPS"]
           :jobs [{:title "Reeths-Puffer Schools"
                   :company "English Language Arts / Social Studies Teacher"
                   :team "5th"
                   :from "Aug 2012"
                   :to "now"
                   :responsibilities
                   [{:text "Taught all subjects during the 2020 - 2021 school year"}
                    {:text "Build positive relationships with students and connected with them individually"}
                    {:text "Engage with students through a PBL model to create learning experiences with a wide impact"}
                    {:text "Work in partnership with community members and stakeholders to bring authenticity and depth to student learning experiences"}
                    {:text "Collaborate with colleagues daily/weekly to create and fine-tune project ideas, give and receive feedback, and discuss student needs"}
                    {:text "Leverage technology tools to support a wide-range of formative assessments and student reflection"}
                    {:text "Implement Positivity Project curriculum; identifying and capitalizing on each students’ character strengths"}
                    {:text "Work effectively with students’ families to inform and strengthen the home/school connection"}
                    {:text "Worked from a virtual platform to meet the needs of both face-to-face learners as well as at home learners. (2020-2021)"}
                    {:text "Attend students' sporting events, dance recitals, and other extracurricular activitiess"}]}
                  {:title "Mona Shores Schools"
                   :company "English Language Arts / Social Studies Teacher"
                   :team "3rd, 4th"
                   :from "Aug 2004"
                   :to "Aug 2012"
                   :responsibilities
                   [{:text "Implemented Readers and Writer's Workshop"}
                    {:text "Built positive relationships with students and connected with them individually"}
                    {:text "Attended students' sporting events, dance recitals, and other extracurricular activities"}
                    {:text "Collaborated with colleagues regularly to plan, implement and review student data"}
                    {:text "Worked closely with families to built raptor and provide for students' individual needs"}
                    {:text "Planned and carried out small group interventions for math and reading"}
                    {:text "Worked within a PBIS model to build positive community and provide tiered supports for students"}]}]}})
