#!/bin/bash

echo "Removing old jar..."
## This is not secure, I guess we should really do a mechanism where we pull from AWS instead of push from here.
ssh -o StrictHostKeyChecking=no $AWS_HOST "rm dev.codecarver*-standalone.jar"
echo "Uploading new jar to AWS..."
scp ./target/uberjar/dev.codecarver*-standalone.jar $AWS_HOST:~/
echo "Running jar in AWS..."
pwd
ssh $AWS_HOST 'bash -s' < deployment/deploy.sh

