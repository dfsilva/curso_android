package models.definitions

import models.{EnqueteId, ValorSensor}
import slick.driver.PostgresDriver.api._

class ValorSensorTable(tag: Tag) extends Table[ValorSensor](tag, "valor_sensor"){

  def valorId = column[Long]("valor_id", O.PrimaryKey)
  def sensorId = column[Long]("sensor_id", O.PrimaryKey)

  def * = (valorId, sensorId) <> ((ValorSensor.apply _).tupled, ValorSensor.unapply)

}

