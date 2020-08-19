import Dependencies._

name := "lambdauz"

version := "1.0"

lazy val `lambdauz` = (project in file(".")).enablePlugins(PlayScala, PlayAkkaHttp2Support)

scalacOptions += "-Ypartial-unification"

scalaVersion := "2.13.1"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

resolvers ++= Seq(
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/",
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= rootDependencies ++ Seq(jdbc, ehcache, ws, specs2 % Test, guice)

      