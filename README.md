
# platform-example-api-tests

Example api tests interacting with services:
- running locally in an sm profile
- deployed to the **public zone** with frontend routes configured
- deployed to the **protected zone** 
- accessible via the [outbound-hods-proxy](https://github.com/hmrc/aws-ami-outbound-hodsproxy)

## Executing the tests:

### Locally with SM:
Start services locally using service manager:

```sm --start PLATFORM_EXAMPLE -f```

Then execute the script: `./run_example_api_test.sh` 

### Against a test environment
To run these tests in jenkins [build](https://build.tax.service.gov.uk/) against the QA environment, execute the script with an environment parameter.  For example: 
```run_example_api_test.sh <environment>```

Where `<environment>` can be any one of either:
- development
- qa
- staging

## Proxy configuration for accessing test environments
This project uses typesafe config to manage proxy configuration in `application.conf`.  The environment variable values for proxy host and port used in the application.conf are compatible with CI.

## Scalafmt
 This repository uses [Scalafmt](https://scalameta.org/scalafmt/), a code formatter for Scala. The formatting rules configured for this repository are defined within [.scalafmt.conf](.scalafmt.conf).

 To apply formatting to this repository using the configured rules in [.scalafmt.conf](.scalafmt.conf) execute:

 ```
 sbt scalafmtAll
 ```

 To check files have been formatted as expected execute:

 ```
 sbt scalafmtCheckAll scalafmtSbtCheck
 ```

[Visit the official Scalafmt documentation to view a complete list of tasks which can be run.](https://scalameta.org/scalafmt/docs/installation.html#task-keys)