testSuccess="$(cat testLog | grep 'Instrumentation testing complete')"
if [[ $testSuccess == 'Instrumentation testing complete.' ]]; then
	buildIdentifier="$(awk -F 'staging.expenses-ab252.appspot.com/' '{print $2}' firebaseLog | awk '{print $1}' | cut -d'/' -f1)"
	echo 'Found build $buildIdentifier'
	gsutil -m cp -r gs://staging.expenses-ab252.appspot.com/$buildIdentifier/**/artifacts/coverage.ec app/build
	if [[ $TRAVIS_BRANCH == 'master' ]]; then 
		./gradlew jacocoTestReport sonarqube; 
	fi
fi
