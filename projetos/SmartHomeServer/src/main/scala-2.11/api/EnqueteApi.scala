package api

import dao.EnqueteDao

import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import mappings.JsonMappings
import models.{Enquete, EnqueteId}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatcher
import spray.json._

trait EnqueteApi extends JsonMappings{
  val enqueteApi =
    (path("uf"/Segment/"enquetes") & get) { uf =>
       complete (EnqueteDao.findByUf(uf).map(_.toJson))
    }~
      (path("enquetes") & post) { entity(as[EnqueteResposta]) { enqueteResposta =>
        complete (EnqueteDao.create2(enqueteResposta.enquete, enqueteResposta.respostas).map(_.toJson))
      }
    }~
      (path("enquetes"/IntNumber) & delete) { id =>
        complete (EnqueteDao.delete(id).map(_.toJson))
    }
}
