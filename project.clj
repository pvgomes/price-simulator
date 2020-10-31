(defproject conversor "0.1.0-SNAPSHOT"
  :description "A price simulator"
  :url "http://gitlab.com/pvgomes/price-simulator"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :min-lein-version "2.0.0"
  :uberjar-name "conversor.jar"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [cheshire "5.8.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [clj-http "3.9.1"]
                 [org.clojure/tools.cli "0.4.1"]
                 [com.amazonaws/aws-lambda-java-core "1.0.0"]]
  :plugins [[lein-cloverage "1.0.13"]
            [lein-ring "0.12.5"]
            [lein-cljfmt "0.5.7"]
            [lein-nsorg "0.2.0"]]

  :ring {:handler conversor.handler/app}

  :aliases {"lint"            ["do" ["cljfmt" "check"] ["nsorg"]]
            "lint-fix"        ["do" ["cljfmt" "fix"] ["nsorg" "--replace"]]}

  :main ^:skip-aot conversor.core

  :test-paths ["test/"]

  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]
                                  [midje "1.9.6"]
                                  [ring/ring-core "1.7.1"]
                                  [ring/ring-jetty-adapter "1.7.1"]]
                   :plugins [[lein-midje "3.2.1"]
                             [lein-cloverage "1.0.13"]]}
             :uberjar {:aot :all}})