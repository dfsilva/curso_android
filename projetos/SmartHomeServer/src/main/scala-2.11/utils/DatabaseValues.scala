package utils


import dao.SensorDao
import models.Sensor
import org.flywaydb.core.Flyway
import slick.dbio.DBIOAction
import slick.profile.SqlAction
import slick.driver.H2Driver.api._

import scala.concurrent.ExecutionContext.Implicits.global

trait DatabaseValues extends DatabaseConfig {

  def inicializarDadosBanco() = {
    db.run(SensorDao.sensorTable.length.result).onSuccess({
      case x:Int => popularDadosSensor(x)
    })
  }

  def popularDadosSensor(size:Int) {
    if (size <= 0) {
      val insertAllAction: DBIOAction[Option[Int], NoStream, Effect.Write] =
        SensorDao.sensorTable ++= Seq(
          Sensor(null, nome = "Sensor 1"),
          Sensor(null, nome = "Sensor 2")
          ,Sensor(null, nome = "Sensor 3")
          ,Sensor(null, nome = "Sensor 4")
          ,Sensor(null, nome = "Sensor 5")
          ,Sensor(null, nome = "Sensor 6")
          ,Sensor(null, nome = "Sensor 7"))

      db.run(insertAllAction.transactionally)
    }
  }

}
