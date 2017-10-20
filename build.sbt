import sbt.Keys.{scalacOptions, _}

scalaVersion in ThisBuild := "2.12.3"

name in ThisBuild := "machete"

organization in ThisBuild := "ai.dragonfly.code"

version in ThisBuild := "0.1"

publishTo in ThisBuild := Some(Resolver.file("file",  new File( "/var/www/maven" )) )

val machete = crossProject.settings(
  // shared settings
  // libraryDependencies ++= Seq()
).jsSettings(
  // JS-specific settings here
  jsDependencies += RuntimeDOM
).jvmSettings(
  // JVM-specific settings here
  libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
)

lazy val js = machete.js

lazy val jvm = machete.jvm

scalacOptions += "-feature"