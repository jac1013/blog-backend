#!/bin/bash

echo "Kill all java processes..."
sudo killall java
echo "Run jar..."
java -jar dev.codecarver*-standalone.jar &
