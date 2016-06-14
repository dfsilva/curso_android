import akka.http.scaladsl.server.Directives._
import api.{ApiErrorHandler, SensoresApi}

trait Routes extends ApiErrorHandler with SensoresApi{
  val routes =
    pathPrefix("v1") {
      enqueteApi
    } ~ path("")(getFromResource("public/index.html"))
}
