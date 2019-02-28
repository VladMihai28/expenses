#!/bin/bash
testSuccess="$(grep 'Instrumentation testing complete' firebaseLog)"
if [[ $testSuccess == 'Instrumentation testing complete.' ]]; then
	buildIdentifier="$(awk -F 'staging.expenses-ab252.appspot.com/' '{print $2}' firebaseLog | awk '{print $1}' | cut -d'/' -f1)"
	buildIdentifier="$(echo -e "${buildIdentifier}" | tr -d '[:space:]')"
	echo "Found build $buildIdentifier"
	gsutil -m cp -r gs://staging.expenses-ab252.appspot.com/$buildIdentifier/**/artifacts/coverage.ec app/build
	./gradlew jacocoTestReport
	java -jar codacy-coverage-reporter-assembly.jar report -l Java -r app/build/jacoco/jacoco.xml
	./gradlew sonarqube;
fi

