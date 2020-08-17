import sbt._

object Dependencies {

  object Versions {
    val cats = "2.1.1"
    val fs2 = "2.4.0"
    val akka = "2.6.8"
    val scalaLogging = "3.9.2"
    val logBack = "1.2.3"
    val logOver = "1.7.30"
    val h2 = "1.4.200"
    val openTable = "0.10.0"
    val postgreSql = "42.2.5"
    val jsonJoda = "2.9.0"
    val pureConfig = "0.13.0"
    val scalaTestPlus = "5.1.0"
    val playMailer = "8.0.1"
    val skunk = "0.0.17"
    val playWebjars = "2.8.0-1"
    val jquery = "3.5.1"
    val bootstrap = "4.5.0"
  }

  object Libraries {
    val cats = "org.typelevel" %% "cats-core" % Versions.cats
    val skunk = "org.tpolecat" % "skunk-core_2.12" % Versions.skunk
    val fs2Core = "co.fs2" %% "fs2-core" % Versions.fs2
    val fs2IO = "co.fs2" %% "fs2-io" % Versions.fs2
    val fs2Reactive = "co.fs2" %% "fs2-reactive-streams" % Versions.fs2
    val fs2Experimental = "co.fs2" %% "fs2-experimental" % Versions.fs2
    val jsonJoda = "com.typesafe.play" %% "play-json-joda" % Versions.jsonJoda
    val pureConfig = "com.github.pureconfig" %% "pureconfig" % Versions.pureConfig
    val scalaTestPlus = "org.scalatestplus.play" %% "scalatestplus-play" % Versions.scalaTestPlus % Test
    val playMailerLibs = Seq(
      "com.typesafe.play" %% "play-mailer" % Versions.playMailer,
      "com.typesafe.play" %% "play-mailer-guice" % Versions.playMailer
    )
    val logLibs = Seq(
      "org.slf4j" % "log4j-over-slf4j" % Versions.logOver,
      "com.typesafe.scala-logging" %% "scala-logging" % Versions.scalaLogging,
      "ch.qos.logback" % "logback-core" % Versions.logBack,
      "ch.qos.logback" % "logback-classic" % Versions.logBack % Test
    )
    val dbLibs = Seq(
      "com.h2database" % "h2" % Versions.h2 % Test,
      "com.opentable.components" % "otj-pg-embedded" % Versions.openTable % Test,
      "org.postgresql" % "postgresql" % Versions.postgreSql
    )
    val akka = Seq(
      "com.typesafe.akka" %% "akka-remote" % Versions.akka,
      "com.typesafe.akka" %% "akka-cluster-sharding-typed" % Versions.akka,
      "com.typesafe.akka" %% "akka-actor-typed" % Versions.akka,
      "com.typesafe.akka" %% "akka-serialization-jackson" % Versions.akka
    )
    val webjarsLibs = Seq(
      "org.webjars" %% "webjars-play" % Versions.playWebjars,
      "org.webjars" % "jquery" % Versions.jquery,
      "org.webjars" % "bootstrap" % Versions.bootstrap
    )
  }

  val rootDependencies: Seq[ModuleID] = Seq(
    Libraries.cats,
    Libraries.fs2Core,
    Libraries.fs2IO,
    Libraries.fs2Reactive,
    Libraries.fs2Experimental,
    Libraries.jsonJoda,
    Libraries.pureConfig,
    Libraries.scalaTestPlus
  ) ++
    Libraries.playMailerLibs ++
    Libraries.logLibs ++
    Libraries.dbLibs ++
    Libraries.akka ++
    Libraries.webjarsLibs
}
