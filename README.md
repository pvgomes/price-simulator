# Price simulator
Sometimes you are buying something out of Brazil using a credit card and thought "How much does it cost?"
The price simulator helps you to simulate it

[![Build Status](https://travis-ci.org/pvgomes/price-simulator.svg?branch=master)](https://travis-ci.org/pvgomes/price-simulator)
[![CircleCI](https://circleci.com/gh/pvgomes/price-simulator.svg?style=svg)](https://circleci.com/gh/pvgomes/price-simulator)

## before commit
- run tests: `lein test`
- run lint-fix: `lein lint-fix`

## set up

### credentials
You must get your own api key on [free currency](https://free.currencyconverterapi.com/) and then export variable by env vars:
```
export API_KEY=YOURAPIKEY
```

WIP ```docker-compose up```

## compile

    $ lein uberjar

## Usage

    $ java -jar conversor-0.1.0-standalone.jar --currency=USB --amount=500

## Examples
`lein ring server-headless`

`lein run --currency=USD --amount=50`

`lein run --currency=EUR --amount=50`

`lein run --currency=ARS --amount=50`


## Deploy on AWS Lambda
This project is serverless and ready to use on [AWS Lambda](https://aws.amazon.com/lambda/) to deploy and run it on Lambda, follow this steps:

Requirements
- You should have [AWS CLI](https://aws.amazon.com/cli/) don't know how to install? See how on [my youtube channel](https://www.youtube.com/watch?v=CFgNFM2qT9U)

1. Create jar
```
lein uberjar
```

2. Create the role to run lambdas

    a) trust-policy.json
    ```
    echo '{
      "Version": "2012-10-17",
      "Statement": [
        {
          "Effect": "Allow",
          "Principal": {
            "Service": "lambda.amazonaws.com"
          },
          "Action": "sts:AssumeRole"
        }
      ]
    }' > trust-policy.json
    ```
    
    b) create this role with one name (our case, lambda-ex)
    `aws iam create-role --role-name lambda-ex --assume-role-policy-document file://trust-policy.json`


    c) You will see the json response and should copy the arn to use it further
    ```
    {
        "Role": {
            "AssumeRolePolicyDocument": {
                "Version": "2012-10-17",
                ...
            },
            ...
            "RoleName": "lambda-ex",
            "Path": "/",
            "Arn": "arn:aws:iam::5072812121311:role/lambda-ex"
        }
    }
    ```

3. Create your lambda (replace arn by your own)
```
aws lambda create-function \
  --function-name price-simulator \
  --handler conversor.core::handler \
  --runtime java8 \
  --memory 512 \
  --timeout 10 \
  --role arn:aws:iam::5072812121311:role/lambda-ex \
  --zip-file fileb://./target/conversor-0.1.0-SNAPSHOT.jar \
  --region us-east-1

```

4. Test it
``` 
aws lambda invoke \
    --function-name price-simulator \
    --payload '"300"' response.json \
    --region=us-east-1
```

Done!

### What we use?
- tools.cli to get args
- clj-http to make http requests
- cheshire to handle JSON

