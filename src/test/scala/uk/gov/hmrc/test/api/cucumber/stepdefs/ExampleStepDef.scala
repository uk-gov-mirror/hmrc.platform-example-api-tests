/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.api.cucumber.stepdefs

import uk.gov.hmrc.test.api.client.ServiceResponse
import uk.gov.hmrc.test.api.utils.ScenarioContext

class ExampleStepDef extends BaseStepDef {

  When("a request is made to the example public endpoint") { () =>
    val response = examplePublicService.helloWorld()
    ScenarioContext.set("response", response)
  }

  When("a request is made to the example private endpoint") { () =>
    val response = examplePrivateService.helloWorld()
    ScenarioContext.set("response", response)
  }

  When("a request is made to a hods proxy endpoint") { () =>
    val response = exampleHoDsService.helloWorld()
    ScenarioContext.set("response", response)
  }

  Then("it should respond successfully") { () =>
    val response: ServiceResponse = ScenarioContext.get("response")
    response.status should be(200)
  }

  And("the response body should be {string}") { expectedBody: String =>
    val response: ServiceResponse = ScenarioContext.get("response")
    response.body shouldBe Some(expectedBody)

  }

}
