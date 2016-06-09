package dao

import dao.SensorDao._
import models._
import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object SensorDao extends BaseDao{

  def findAll():Future[Seq[Sensor]] = {
    sensorTable.result
  }

}
