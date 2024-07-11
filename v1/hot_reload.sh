#!/bin/bash

# Check if a process is running on port 8080
PID=$(lsof -ti :8080)

if [ -n "$PID" ]; then
    echo "Killing process with PID $PID"
    kill -9 $PID
fi

# Run Gradle bootRun
./gradlew bootRun

