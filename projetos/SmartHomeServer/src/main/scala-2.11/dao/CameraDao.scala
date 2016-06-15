package dao

import dao.SensorDao._
import models._
import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object CameraDao extends BaseDao{

  def findAll():Future[Seq[Camera]] = {
    cameraTable.result
  }

}
