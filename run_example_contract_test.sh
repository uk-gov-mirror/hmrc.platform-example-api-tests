#!/bin/bash -e

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
sbt scalafmtCheckAll scalafmtSbtCheck

sbt -Denvironment=qa "testOnly uk.gov.hmrc.test.api.cucumber.runner.ContractAPIExampleRunner"
