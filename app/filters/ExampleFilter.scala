package filters

import akka.stream.Materializer
import javax.inject._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ExampleFilter @Inject()(
    implicit override val mat: Materializer,
    exec: ExecutionContext) extends Filter {

  override def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {
    // Run the next filter in the chain. This will call other filters
    // and eventually call the action. Take the result and modify it
    // by adding a new header.
    nextFilter(requestHeader).map { result =>
      result.withHeaders("X-ExampleFilter" -> "foo")
    }
  }

}
