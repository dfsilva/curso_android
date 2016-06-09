import akka.http.scaladsl.server.Directives._
import api.{ApiErrorHandler, EnqueteApi}

trait Routes extends ApiErrorHandler with EnqueteApi{
  val routes =
    pathPrefix("v1") {
      enqueteApi
    } ~ path("")(getFromResource("public/index.html"))
}
