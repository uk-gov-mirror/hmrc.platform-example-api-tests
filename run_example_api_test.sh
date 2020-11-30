#!/bin/bash -e
env=${1:-local}

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
sbt scalafmtCheckAll scalafmtSbtCheck

sbt -Denvironment=${env} "testOnly uk.gov.hmrc.test.api.cucumber.runner.APIExampleRunner"

