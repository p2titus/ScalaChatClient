organization := "com.titus"

name := "scala-chat"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  // https://mvnrepository.com/artifact/org.scalatest/scalatest - scalatest
  "org.scalatest" %% "scalatest" % "3.2.2" % Test,
  // https://mvnrepository.com/artifact/com.typesafe.slick/slick - db access
  "com.typesafe.slick" %% "slick" % "3.3.3",
  // code gen for db
  "com.typesafe.slick" %% "slick-codegen" % "3.3.3",
  // debug logging
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  // connection pool support
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"
)
