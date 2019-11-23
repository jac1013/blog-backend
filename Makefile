all: deps lint test

deps:
		lein deps

lint:
		lein kibit

test:
		lein test

build:
		lein uberjar

check-dependencies:
		lein ancient

coverage:
		lein cloverage --lcov

check-vulnerabilities:
		lein nvd check

complete-analysis:
		make lint coverage check-dependencies check-vulnerabilities





