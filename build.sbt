import Dependencies._

ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / version          := "PRE-ALPHA"
ThisBuild / organization     := "com.p2titus"
ThisBuild / organizationName := "p2titus"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaChatClient",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
