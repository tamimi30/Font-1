#!/usr/bin/env sh

# Gradle wrapper shell script

# This script is responsible for launching the Gradle Wrapper. It will download the Gradle distribution if it is not already present.

# Set the default Gradle version
GRADLE_VERSION=6.8.3

# Define the location of the Gradle wrapper jar
WRAPPER_JAR="gradle/wrapper/gradle-wrapper.jar"

# Check if the Gradle wrapper jar exists
if [ ! -f "$WRAPPER_JAR" ]; then
    echo "Gradle wrapper jar not found. Please run 'gradle wrapper' to generate it."
    exit 1
fi

# Execute the Gradle wrapper
exec java -jar "$WRAPPER_JAR" "$@"