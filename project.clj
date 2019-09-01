(defproject conversor "0.1.0-SNAPSHOT"
  :description ""
  :url "http://gitlab.com/pvgomes/price-simulator"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :plugins [[lein-cloverage "1.0.13"]
            [lein-cljfmt "0.5.7"]
            [lein-nsorg "0.2.0"]]

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "3.9.1"]
                 [cheshire "5.8.1"]
                 [org.clojure/tools.cli "0.4.1"]]

  :aliases {"lint"            ["do" ["cljfmt" "check"] ["nsorg"]]
            "lint-fix"        ["do" ["cljfmt" "fix"] ["nsorg" "--replace"]]}

  :main ^:skip-aot conversor.core

  :test-paths ["test/"]

  :profiles {:uberjar {:aot :all}})
