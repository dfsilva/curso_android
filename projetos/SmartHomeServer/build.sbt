name := "SmartHomeServer"

organization  := "br.com.diegosilva"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" % "akka-actor_2.11" % "2.4.5",
    "com.typesafe.akka" % "akka-stream_2.11" % "2.4.5",
    "com.typesafe.akka" % "akka-http-experimental_2.11" % "2.4.5",
    "com.typesafe.akka" % "akka-http-core_2.11" % "2.4.5",
    "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % "2.4.5",
    "com.typesafe.slick" % "slick_2.11" % "3.1.1",
    "com.typesafe.slick" % "slick-hikaricp_2.11" % "3.1.1",
    "com.mchange" % "c3p0" % "0.9.5.2",
    "org.slf4j"          %  "slf4j-nop" % "1.7.21",
    "com.h2database" % "h2" % "1.4.192",
    "org.flywaydb"       %  "flyway-core" % "4.0.1"
  )
}

