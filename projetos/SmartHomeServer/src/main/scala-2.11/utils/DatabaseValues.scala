package utils


import dao.SensorDao
import models.Sensor
import org.flywaydb.core.Flyway
import slick.dbio.DBIOAction
import slick.profile.SqlAction
import slick.driver.H2Driver.api._

import scala.concurrent.ExecutionContext.Implicits.global

trait DatabaseValues extends DatabaseConfig {


  def popularBanco() = {

    val insertAllAction : DBIOAction[Option[Int], NoStream, Effect.Write] =
      SensorDao.sensorTable ++= Seq(
        Sensor(null,nome = "Sensor 1"),
        Sensor(null,nome = "Sensor 2"))


    db.run(insertAllAction.transactionally) foreach(f =>{
      System.out.println("Valor inserido")
    })


  }



}
