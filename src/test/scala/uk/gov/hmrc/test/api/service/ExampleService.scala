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

package uk.gov.hmrc.test.api.service

import uk.gov.hmrc.test.api.client.{HttpClient, ServiceResponse}
import uk.gov.hmrc.test.api.conf.TestConfiguration

import scala.concurrent.Await
import scala.concurrent.duration._

class ExampleService(client: HttpClient) {

  def publicEndpoint(): ServiceResponse = {
    val url = TestConfiguration.url("platops-example-backend-microservice") + "/hello-world"
    Await.result(
      client.GET(url),
      10.seconds
    )
  }

  def privateEndpoint(): ServiceResponse = {
    val url = TestConfiguration.url("platops-example-private-backend-microservice") + "/hello-world"
    Await.result(
      client.GET(url),
      10.seconds
    )
  }

  def hodsEndpoint(): ServiceResponse = {
    val url = TestConfiguration.url("outbound-hods-proxy") + "/business-details/mtdbsa/XKIT00000000074"
    Await.result(
      client.GET(
        url,
        ("Environment", "ist0"),
        ("Authorization", "Bearer EvYRlYH8AS_hZGw32ffqJ25Mz04a"),
        ("ContentType", "application/json;charset=utf-8")
      ),
      60.seconds
    )
  }
}
