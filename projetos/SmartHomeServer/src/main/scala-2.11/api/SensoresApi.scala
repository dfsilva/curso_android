package api

import dao.SensorDao

import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import mappings.JsonMappings

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatcher
import spray.json._

trait SensoresApi extends JsonMappings{
  val enqueteApi =
    (path("sensores") & get) {
       complete (SensorDao.findAll().map(_.toJson))
    }
}
