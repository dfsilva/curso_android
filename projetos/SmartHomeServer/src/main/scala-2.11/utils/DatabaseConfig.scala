package utils

import com.mchange.v2.c3p0.ComboPooledDataSource

trait DatabaseConfig extends Config{
  val driver = slick.driver.PostgresDriver

  import driver.api._

  def db = {
      Database.forDataSource(ds)
  }

  implicit val ds = new ComboPooledDataSource
  ds.setDriverClass(databaseDriver)
  ds.setJdbcUrl(databaseUrl)
  ds.setUser(databaseUser)
  ds.setPassword(databasePassword)
  ds.setMinPoolSize(3)
  ds.setAcquireIncrement(5)
  ds.setMaxPoolSize(20)
  ds.setMaxStatements(180)
  ds.setIdleConnectionTestPeriod(180)
  ds.setPreferredTestQuery("SELECT 1")
  ds.setMaxIdleTime(600)
  ds.setTestConnectionOnCheckout(true)
  ds.setTestConnectionOnCheckin(true)

  implicit val session: Session = db.createSession()
}