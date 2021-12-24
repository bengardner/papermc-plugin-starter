#!/bin/sh
WORKSPACE=".papermc"
MC_VERSION="1.18.1"
PAPER_BUILD="101"

## ============== DO NOT EDIT THE SCRIPT BELOW UNLESS YOU KNOW WHAT YOU ARE DOING ============== ##

cd || exit # Moving to the user folder or exit if it fails.

# Checking the workspace folder availability.
if [ ! -d $WORKSPACE ]; then
	# Create the workspace folder.
	mkdir $WORKSPACE
fi

cd $WORKSPACE || exit # Moving to the workspace fodler or exit if it fails.

# Check for the paper executable
PAPER_JAR="paper-$MC_VERSION-$PAPER_BUILD.jar"
PAPER_LNK="https://papermc.io/api/v2/projects/paper/versions/$MC_VERSION/builds/$PAPER_BUILD/downloads/$PAPER_JAR"

echo "URL:" $PAPER_LNK

if [ ! -f $PAPER_JAR ]; then
	#curl -X 'GET' -H 'accept: application/json' -O $PAPER_JAR $PAPER_LNK
	wget $PAPER_LNK
fi

java -jar $PAPER_JAR --nogui
