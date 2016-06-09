package models.definitions

import models.{Sensor, SensorId}
import slick.driver.PostgresDriver.api._

class SensorTable(tag: Tag) extends Table[Sensor](tag, "sensor"){

  def id = column[SensorId]("id", O.PrimaryKey, O.AutoInc)
  def nome = column[String]("nome")

  def * = (id.?, nome) <> ((Sensor.apply _).tupled, Sensor.unapply)

}

