import com.typesafe.sbt.SbtAspectj._

name := """kamon-akka"""

version := "1.0"

scalaVersion := "2.11.7"

val kamonVersion = "0.5.1"

libraryDependencies ++= Seq(
  "io.kamon" %% "kamon-core" % kamonVersion,
  "io.kamon" %% "kamon-akka" % kamonVersion,
  "io.kamon" %% "kamon-statsd" % kamonVersion,
  "io.kamon" %% "kamon-log-reporter" % kamonVersion,
  "io.kamon" %% "kamon-system-metrics" % kamonVersion,
  "org.aspectj" % "aspectjweaver" % "1.8.5",
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test")

aspectjSettings

javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true