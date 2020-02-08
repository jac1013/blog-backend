all: deps lint test .env

.PHONY: all test clean build

deps:
		lein deps

lint:
		lein kibit

test:
		lein test

.env:
		cp .env-template .env && cp .env.test-template ./.env.test

clean:
		rm -fr ./target/*

build:
		make clean && lein uberjar

run:
		lein core-test

api:
		lein api

check-dependencies:
		lein ancient

coverage:
		lein cloverage --lcov

check-vulnerabilities:
		lein nvd check

complete-analysis:
		make lint coverage check-dependencies check-vulnerabilities

run-db:
		docker-compose up

format:
		lein cljfmt fix

integration-test:
		export APP_ENV=test && docker-compose -f docker-compose-test.yml up -d && sleep 5 && lein test :integration && docker-compose -f docker-compose-test.yml stop test






