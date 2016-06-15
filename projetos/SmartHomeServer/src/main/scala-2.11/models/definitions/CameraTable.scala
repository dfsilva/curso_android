package models.definitions

import models.{Camera, CameraId}
import slick.driver.PostgresDriver.api._

class CameraTable(tag: Tag) extends Table[Camera](tag, "camera"){

  def id = column[CameraId]("id", O.PrimaryKey, O.AutoInc)
  def nome = column[String]("nome")
  def snapshotUrl = column[String]("snapshot_url")

  def * = (id.?, nome, snapshotUrl) <> ((Camera.apply _).tupled, Camera.unapply)

}

