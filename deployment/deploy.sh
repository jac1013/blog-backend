#!/bin/bash

echo "Kill all java processes..."
sudo killall java
echo "Run jar..."
nohup java -jar dev.codecarver*-standalone.jar &>/dev/null &
