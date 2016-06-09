import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import utils.{Config, DatabaseValues, MigrationConfig}

import scala.concurrent.ExecutionContext

object Main extends App with Config with MigrationConfig with Routes with DatabaseValues{
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected val log: LoggingAdapter = Logging(system, getClass)
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  migrate()
  popularBanco()


  //Http().bindAndHandle(handler = logRequestResult("log")(routes), interface = httpInterface, port = httpPort)

  Http().bindAndHandle(routes, interface = httpInterface, port = httpPort)
}