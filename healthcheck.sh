#!/usr/bin/env bash

# Wait for the Selenium Grid hub to be ready
echo "Checking if hub is ready - $HUB_HOST"
while [ "$(curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready)" != "true" ]; do
  sleep 1
done

echo "HUB_HOST===================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: $HUB_HOST"
echo "BROWSER==========================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: $BROWSER"
echo "MODULE=====================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: $MODULE"

# Start the Java command
#java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST="$HUB_HOST" -DBROWSER="$BROWSER" org.testng.TestNG "$MODULE" > test_output.log 2>&1
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST="$HUB_HOST" -DBROWSER="$BROWSER" org.testng.TestNG -suiteXmlFile facebook.xml > test_output.log 2>&1

# Capture the exit code of the Java command
exit_code=$?

# Display the exit code
echo "Container exiting with code: $exit_code"

# Exit with the captured exit code
exit $exit_code
