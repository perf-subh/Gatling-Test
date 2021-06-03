import scala.concurrent.duration._
import scala.language.postfixOps
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class perftest extends Simulation {

    // Let's split this big scenario into composable business processes, like one would do with PageObject pattern with Selenium

    // object are native Scala singletons
    object Search {

        val search =
           group("Request1") {
        exec(
            http("Page1") // let's give proper names, they are displayed in the reports, and used as keys
              .get("/posts")
            // .check(status.is(304))
        )

          .pause(0)
    }}
    val httpProtocol = http
      .baseUrl("https://jsonplaceholder.typicode.com")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .doNotTrackHeader("1")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

    // Now, we can write the scenario as a composition
    val scn = scenario("Scenario Name")
      .forever() {
          exec(Search.search).pause(3)
      }
    setUp(scn.inject(atOnceUsers(3))
      .protocols(httpProtocol)).maxDuration(1 minute)
}
