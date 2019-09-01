# Price simulator
Sometimes you are buying something out of Brazil using a credit card and thought "How much does it cost?"
The price simulator helps you to simulate it

[![Build Status](https://travis-ci.org/pvgomes/price-simulator.svg?branch=master)](https://travis-ci.org/pvgomes/price-simulator)
[![CircleCI](https://circleci.com/gh/pvgomes/price-simulator.svg?style=svg)](https://circleci.com/gh/pvgomes/price-simulator)

## before commit
- run tests: `lein test`
- run lint-fix: `lein lint-fix`

## set up

WIP ```docker-compose up```

## compile

    $ lein uberjar

## Usage

    $ java -jar conversor-0.1.0-standalone.jar --currency=USB --amount=500

## Examples
`lein run --currency=USD --amount=50`

`lein run --currency=EUR --amount=50`

`lein run --currency=ARS --amount=50`




### What we use?
- tools.cli to get args
- clj-http to make http requests
- cheshire to handle JSON

