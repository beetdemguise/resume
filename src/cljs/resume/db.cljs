(ns resume.db)

(defn add-emacs
  "Preach it Brother."
  [responsibilities]
  (map #(update % :tags conj "emacs / cider") responsibilities))

(def default-db
  {:highlights {:job nil
                :buzzwords nil}
   :_info {:name "Darin Douglass"
           :title "Principal Software Engineer"
           :contact-methods [{:icon :i.far.fa-building
                              :text "Michigan (EST/EDT)"}
                             {:icon :i.far.fa-envelope
                              :href "mailto:douglassdarin+resume@gmail.com"
                              :text "douglassdarin@gmail.com"}
                             {:icon :i.fas.fa-phone
                              :text "(616) 312 - 9313"}
                             {:icon :i.fab.fa-github
                              :href "https://github.com/darindouglass"
                              :text "darindouglass"}
                             {:icon :i.fab.fa-linkedin-in
                              :href "https://linkedin.com/in/darin-douglass-57400158/"
                              :text "darin-douglass"}]
           :degrees [{:name "B.S."
                      :icon "gv.jpg"
                      :major "Computer Science"
                      :university "Grand Valley State University"}]
           :hobbies ["Playing with my kids"
                     "Bowling"
                     {:href "https://www.youtube.com/watch?v=_CI-0E_jses"
                      :text "Playing jazz music"}
                     {:href "https://www.youtube.com/watch?v=bXZhTb0eUqA&t=118s"
                      :text "Playing long video games"}]
           :buzzwords
           [;; languages
            "clojure"
            "babashka"
            "python"
            "perl"
            "javascript"
            ;; systems
            "kafka"
            "rabbit"
            "postgres"
            "cassandra"
            "elasticsearch"
            "dbt"
            "redshift"
            ;; tools
            "emacs / cider"
            "kubernetes"
            "docker"
            "aws"
            "terraform"
            "prefect"
            "aws glue"
            ;; abstract ideas
            "streaming"
            "observability"
            "orchestration"
            "data"
            "data warehouse"
            "team-building"
            "ergonomics"
            "performance"
            "distributed systems"
            "CI / CD"
            "git ops"]
           :jobs [{:title "Senior Data Engineer"
                   :company "OneStudyTeam"
                   :team "Data Engineering"
                   :from "Sept 2021"
                   :to "Dec 2022"
                   :responsibilities
                   (add-emacs
                    [{:tags #{"clojure" "babashka" "python" "dbt" "data" "data warehouse" "aws glue" "redshift" "terraform" "observability" "ergonomics"}
                      :text "Implemented a full, pluggable SageMaker notebooking environment used by data and ML scientists"}
                     {:tags #{"clojure" "babashka" "python" "dbt" "data" "data warehouse" "aws glue" "redshift" "terraform" "observability"}
                      :text "Improved traditional Glue-based data-ingest latency from hours to minutes"}
                     {:tags #{"clojure" "babashka" "python" "dbt" "data" "data warehouse" "aws glue" "redshift" "terraform" "orchestation" "prefect"}
                      :text "Designed a simple-to-use Prefect flow system with full CI/CD workflows"}
                     {:tags #{"clojure" "babashka" "python" "dbt" "data" "data warehouse" "aws glue" "redshift" "terraform" "kafka" "streaming"}
                      :text "Wrote a windowed schema implementation to allow more lenient data ingest"}
                     {:tags #{"clojure" "babashka" "python" "dbt" "data" "data warehouse" "aws glue" "redshift" "terraform" "ergonomics"}
                      :text "Wrote and maintained several composable libraries designed to improve code habits and ergonomics"}])}
                  {:title "Principal Software Engineer / Scrum Master"
                   :company "Barracuda Networks"
                   :team "Sonian"
                   :from "Jan 2018"
                   :to "Sept 2021"
                   :responsibilities
                   (add-emacs
                    [{:tags #{"clojure" "babashka" "javascript" "distributed systems" "elasticsearch" "performance" "postgres" "rabbit" "aws"}
                      :text "Maintained, observed, and improved a distributed system that handles millions of email per day"}
                     {:tags #{"clojure" "kubernetes" "docker" "aws" "CI / CD" "git ops"}
                      :text "Developed a data-driven, manifest generation tool for Kubernetes resources"}
                     {:tags #{"clojure" "team-building" "distributed systems" "observability"}
                      :text "Mentored developers through the learning curve of Clojure and our system"}
                     {:tags #{"clojure" "observability" "docker" "performance"}
                      :text "Implemented structured, action-able logging into a alongisde opaque legacy system"}
                     {:tags #{"clojure" "kafka" "kubernetes" "postgres" "streaming"}
                      :text "Refactored an obtuse auditing service with well-defined, search-able events"}
                     {:tags #{"clojure" "distributed systems" "kafka" "performance" "postgres" "elasticsearch" "streaming"}
                      :text "Designed and implement a streaming service for removing customer information from custom and encrypted files"}
                     {:tags #{"clojure" "kubernetes"}
                      :text "Removed expensive and complicated 3rd party rendering system with open-source tooling"}
                     {:tags #{"ergonomics" "team-building" "distributed systems"}
                      :text "Lead the team through architectural decisions, sprints, and retrospectives"}
                     {:tags #{"team-building" "distributed systems"}
                      :text "Helped coordinate bi-weekly movie/gaming nights for our entirely remote team"}
                     {:tags #{"ergonomics" "git ops" "aws" "kubernetes" "docker" "CI / CD"}
                      :text "Coordinated with operations on 3rd party integrations (sensu, sumologic, ELK) and sun-setting of legacy deployment systems (Chef, EC2)"}
                     {:tags #{"ergonomics" "CI / CD" "git ops"}
                      :text "Managed CI / CD operations via Jenkins, Github Actions, Artifactory, and flux"}])}
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
                      :text "Refactored exporting to provide better throughput and checkpointing"}])}
                  #_{:title "Software Engineer I"
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
                       :text "Optimized stored procedures for use in multi-threaded operations"}
                      {:tags #{"team-building"}
                       :text "Collaborated with customers through the design and implementation of their warehouse solution"}]}]}})
