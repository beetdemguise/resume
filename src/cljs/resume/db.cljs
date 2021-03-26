(ns resume.db)

(defn add-emacs
  "Preach it Brother."
  [responsibilities]
  (map #(update % :tags conj "emacs / cider") responsibilities))

(def default-db
  {:highlights {:job nil
                :buzzwords nil}
   :_info {:name "Darin Douglass"
           :title "Software Engineer"
           :contact-methods [{:icon :i.far.fa-envelope
                              :href "mailto:douglassdarin+resume@gmail.com"
                              :text "douglassdarin@gmail.com"}
                             {:icon :i.fas.fa-phone-alt
                              :text "(616) 312 - 9313"}
                             {:icon :i.fab.fa-github
                              :href "https://github.com/darindouglass"
                              :text "darindouglass"}
                             {:icon :i.fab.fa-linkedin-in
                              :href "https://linkedin.com/in/darin-douglass-57400158/"
                              :text "darin-douglass"}]
           :degrees [{:name "B.S."
                      :icon "assets/gv.jpg"
                      :major "Computer Science"
                      :university "Grand Valley State University"}]
           :hobbies ["Playing with my kids"
                     {:title "The Wheel weaves as The Wheel wills"
                      :text "Reading thick books"}
                     {:href "https://www.youtube.com/watch?v=_CI-0E_jses"
                      :text "Playing jazz music"}
                     {:href "https://www.youtube.com/watch?v=bXZhTb0eUqA"
                      :text "Playing long video games"}]
           :buzzwords
           [;; languages
            "clojure"
            "python"
            "perl"
            "javascript"
            ;; systems
            "kafka"
            "rabbit"
            "postgres"
            "cassandra"
            "elasticsearch"
            ;; tools
            "emacs / cider"
            "kubernetes"
            "docker"
            "aws"
            ;; abstract ides
            "streaming"
            "observability"
            "team-building"
            "ergonomics"
            "performance"
            "distributed systems"
            "CI / CD"
            "git ops"]
           :jobs [{:title "Senior Software Engineer / Scrum Master"
                   :company "Barracuda Networks"
                   :team "Sonian"
                   :from "Jan 2018"
                   :to "now"
                   :responsibilities
                   (add-emacs
                    [{:tags #{"clojure" "javascript" "distributed systems" "elasticsearch" "performance" "postgres" "rabbit" "aws"}
                      :text "Maintain, observe, and improve a distributed system that handles tens of millions of email per day"}
                     {:tags #{"clojure" "team-building" "distributed systems" "observability"}
                      :text "Mentor junior developers through the learning curve of Clojure and our system"}
                     {:tags #{"clojure" "observability" "docker" "performance"}
                      :text "Implement actionable and structured logging into a previously opaque legacy system"}
                     {:tags #{"clojure" "kafka" "kubernetes" "postgres" "streaming"}
                      :text "Reimplement previously-obtuse auditing service with well-defined, searchable user events"}
                     {:tags #{"clojure" "distributed systems" "kafka" "performance" "postgres" "elasticsearch" "streaming"}
                      :text "Design and implement a streaming service for removing customer information from custom and encrypted files"}
                     {:tags #{"clojure" "kubernetes"}
                      :text "Remove expensive and complicated 3rd party rendering system with open-source tooling"}
                     {:tags #{"ergonomics" "team-building" "distributed systems"}
                      :text "Lead the team through architectural decisions, sprints, and retrospectives"}
                     {:tags #{"team-building" "distributed systems"}
                      :text "Help coordinate bi-weekly movie/gaming nights for our entirely remote team"}
                     {:tags #{"clojure" "kubernetes" "docker" "aws" "CI / CD" "git ops"}
                      :text "Develop a data-driven, manifest generation tool for Kubernetes resources"}
                     {:tags #{"ergonomics" "git ops" "aws" "kubernetes" "docker" "CI / CD"}
                      :text "Coordinate with operations on 3rd party integrations (sensu, sumologic, ELK) and sunsetting of legacy deployment systems (Chef, EC2)"}
                     {:tags #{"ergonomics" "CI / CD" "git ops"}
                      :text "Manage CI / CD operations via Jenkins, Github Actions, Artifactory, and flux"}])}
                  {:title "Senior Software Engineer"
                   :company "Barracuda Networks"
                   :team "Cloud Archiving"
                   :from "Aug 2015"
                   :to "Jan 2018"
                   :responsibilities
                   (add-emacs
                    [{:tags #{"python" "perl" "ergonomics" "cassandra"}
                      :text "Simplified customer support experience with a python/Flask UI layer"}
                     {:tags #{"elasticsearch" "python" "perl"}
                      :text "Improved performance of per-customer statistics gathering"}
                     {:tags #{"elasticsearch" "cassandra" "CI / CD"}
                      :text "Helped maintain fleets of servers including Elasticsearch and Cassandra nodes"}
                     {:tags #{"CI / CD" "ergonomics" "perl"}
                      :text "Worked with operations to improve and update our Puppet code"}
                     {:tags #{"python" "observability" "javascript" "perl" "cassandra" "elasticsearch"}
                      :text "Reimplemented customer exports to provide better chunking, throughput, and checkpoint functionality"}])}
                  {:title "Software Engineer I"
                   :company "Dematic"
                   :team "Sort"
                   :from "Jan 2014"
                   :to "Aug 2015"
                   :responsibilities
                   [{:tags #{"javascript" "performance"}
                     :text "Designed and commissioned extensive route-based, message-driven warehouse storage solutions"}
                    {:tags #{"observability"}
                     :text "Interfaced with 3rd party warehouse management and conveyor systems"}
                    {:tags #{"performance"}
                     :text "Optimized stored prodedures for use in multi-threaded operations"}
                    {:tags #{"team-building"}
                     :text "Collaborated with customers through the design and implementation of their warehouse solution"}]}]}})
