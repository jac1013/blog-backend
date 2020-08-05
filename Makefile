all: deps lint test .env docker

.PHONY: all test clean build

deps:
		lein deps

test:
		lein test

lint:
		lein kibit

.env:
		cp .env-template .env && cp .env.test-template ./.env.test

docker:
		docker-compose build && docker-compose -f docker-compose-test.yml build

clean:
		rm -fr ./target/*

build:
		make clean && lein uberjar

run:
		lein api

check-dependencies:
		lein ancient

coverage:
		CLOVERAGE_VERSION=1.0.11-20180518.155428-32 lein with-profile +test,+cloverage cloverage --lcov

check-vulnerabilities:
		lein nvd check

complete-analysis:
		make lint coverage check-dependencies check-vulnerabilities

run-db:
		sudo docker-compose up

format:
		lein cljfmt fix

integration-test:
		export APP_ENV=test && sudo docker-compose -f docker-compose-test.yml up -d --build && sleep 10 && lein test :integration && docker-compose -f docker-compose-test.yml down -v --remove-orphans && sudo rm -rf postgresql_data_test && sudo rm -rf postgresql_test




