package models.definitions

import models.{SensorId, ValorSensor, ValorSensorId}
import slick.driver.PostgresDriver.api._

class ValorSensorTable(tag: Tag) extends Table[ValorSensor](tag, "valor_sensor"){

  def id = column[ValorSensorId]("id", O.PrimaryKey, O.AutoInc)
  def sensorId = column[SensorId]("sensor_id")
  def valor = column[Double]("valor")

  def * = (id.?, sensorId, valor) <> ((ValorSensor.apply _).tupled, ValorSensor.unapply)

}

