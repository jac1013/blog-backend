#!/bin/bash

echo "Removing old jar..."
ssh $AWS_HOST "rm dev.codecarver*-standalone.jar"
echo "Uploading new jar to AWS..."
rsync -avr ./target/uberjar/dev.codecarver*-standalone.jar $AWS_HOST:~/
echo "Running jar in AWS.."
pwd
ssh $AWS_HOST 'bash -s' < deployment/deploy.sh

