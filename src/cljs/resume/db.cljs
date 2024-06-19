(ns resume.db)

(defn add-emacs
  "Preach it Brother."
  [responsibilities]
  (map #(update % :tags conj "emacs / cider") responsibilities))

(def default-db
  {:highlights {:job nil
                :buzzwords nil}
   :_info {:name "Melisa Overway"
           :letter
           {:when "June 18, 2024"
            :greeting "Greetings"
            :body "As a school counselor I have known Melisa for ten years. In my 37 years in education, she is an exemplar to all in education. 

Regularly I would tell Melisa that I wished my kids could have had her as a teacher. One day, while watching her lovingly teach her students, seeing each one of them for the gift they are, I realized I wished I had had her for a teacher. Being in Mrs. Overway’s classroom leaves a mark of “you matter,” “you are filled with purpose,” “you are able to appreciate other people’s gifts.” Quantifying the impact of being Mrs. Overway’s student would be a large task indeed. 

Melisa’s soft skills are superior, for certain, but her hard skills are no less impressive. She weaves State Standards into lessons that pull kids in like it was their idea to write, read, or complete a project. Melisa starts with a strong pedagogical foundation and creates the lesson around the interests of the students in front of her. Each year has its own layered personality, which makes it both interesting for the students and her. 

Building classroom chemistry comes from multiple trainings and continuously seeking the latest ways to lead all students to the understanding that they belong. Each week the Pineapple Award recipient was obvious by the student marching through the hallway with enormous pineapple glasses, carrying their fresh pineapple. As a staff we found the pride in the kids both humorous and heartwarming. Even parents proudly posted their children as that week’s Pineapple Award Recipient. This award was so coveted that even during Covid, she and her teammate created sneak attacks with spy moves to deliver pineapples to students who engaged with their online learning, right to their door steps. 

As a colleague of Melisa, the impact on me is palpable. When having a rough day, I would head to her space for a sense of peace. The reset allowed me to soften and be a better counselor for the students I serve. She was also willing to help with students from other rooms and other grades. Melisa made herself available to all kids and staff. 

Melisa will be a gift to any school she steps foot in, and I give her my highest recommendation."
            :from {:name "Kelley Peel"
                   :contact-methods
                   [{:href "mailto:kelley@kelleypeel.com"
                     :text "kelley@kelleypeel.com"}
                    {:text "(231) 329 - 2510"}]}}
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
           :projects [{:text "Empathy Podcasts" :href "https://galleries.vidflow.co/videos/fvd3a961"
                       :summary '([:div.italic "How does knowing someone’s story help us to develop empathy?"]
                                  #_[:div "Through books, community partners and their own sharing, we began to see the people around us as individuals carrying both tragic and honest stories."]
                                  [:div "Students grouped up to learn how to develop a podcast, displaying what they wanted to teach others about empathy."]
                                  [:div "Each podcast was made public and they the MACUL conference podcast contest. One of our groups won " [:span.emphasis "3rd place!"]
                                   ])}
                      {:text "Long Walk to Water" :href "https://vimeo.com/957070061?share=copy"
                       :summary '([:div.italic "How do we recognize strength in other people? "]
                                  [:div "Students explored the civil war in Southern Sudan and the global water crisis through the book, " [:span.emphasis "A Long Walk to Water."]]
                                  #_[:div "They also took trips to the local wastewater management site and water filtration plant to discover and understand our own precious water source and the efforts it takes to maintain them."]
                                  [:div "Students raised " [:span.emphasis "$1,700"] " to donate to Water for South Sudan, a nonprofit water charity seeking to bring healing to Sudanese villages."])}]
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
                    {:text "Engage with students through a PBL model to create impactful learning experiences"}
                    {:text "Work in partnership with community members and stakeholders to bring authenticity and depth to student learning experiences"}
                    {:text "Collaborate with colleagues daily/weekly to create and fine-tune project ideas, give and receive feedback, and discuss student needs"}
                    {:text "Leverage technology tools to support a wide-range of formative assessments and student reflection"}
                    {:text "Implement Positivity Project curriculum; identifying and capitalizing on each students’ character strengths"}
                    {:text "Work effectively with students’ families to strengthen the home/school connection"}
                    {:text "Worked from a virtual platform to meet the needs of both face-to-face learners as well as at home learners. (2020-2021)"}
                    {:text "Attend students' sporting events, dance recitals, and other extracurriculars"}]}
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
