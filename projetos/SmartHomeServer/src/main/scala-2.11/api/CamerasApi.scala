package api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import dao.SensorDao
import mappings.JsonMappings
import spray.json._

import scala.concurrent.ExecutionContext.Implicits.global

trait CamerasApi extends JsonMappings{
  val camerasApi =
    (path("cameras") & get) {
       complete (SensorDao.findAll().map(_.toJson))
    }
}
