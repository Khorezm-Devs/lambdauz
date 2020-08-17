name := "lambdauz"
 
version := "1.0" 
      
lazy val `lambdauz` = (project in file(".")).enablePlugins(PlayScala, PlayAkkaHttp2Support)


scalacOptions += "-Ypartial-unification"
resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

scalaVersion := "2.12.8"
val CatsVersion = "2.1.1"
val pgSqlDriver = "org.postgresql" % "postgresql" % "42.2.5"
val AkkaVersion = "2.6.8"
val akkaLibs = Seq(
  "com.typesafe.akka" %% "akka-remote" % AkkaVersion,
  "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion
)

val catsLibs = Seq(
  "org.typelevel" %% "cats-core" % CatsVersion,
  "co.fs2" %% "fs2-core" % "2.4.0",
  "co.fs2" %% "fs2-io" % "2.4.0",
  "co.fs2" %% "fs2-reactive-streams" % "2.4.0",
  "co.fs2" %% "fs2-experimental" % "2.4.0",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "com.chuusai" %% "shapeless" % "2.4.0-SNAPSHOT"
)

val skunkLibs = Seq(
  "org.tpolecat" % "skunk-core_2.12" % "0.0.17"
)

val loggingLibs = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
  "ch.qos.logback" % "logback-core" % "1.2.3",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.30",
  "org.codehaus.janino" % "janino" % "3.1.2"
)

val dbLibs = Seq(
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "com.github.tminglei" %% "slick-pg" % "0.19.2",
  "com.github.tminglei" % "slick-pg_play-json_2.12" % "0.19.2",
  "com.h2database" % "h2" % "1.4.200" % Test,
  "com.opentable.components" % "otj-pg-embedded" % "0.10.0" % Test,
  pgSqlDriver
)

libraryDependencies ++= akkaLibs ++ catsLibs ++ skunkLibs ++ loggingLibs ++ dbLibs ++ Seq(jdbc, ehcache, ws, specs2 % Test, guice,
  "com.typesafe.play" %% "play-json-joda" % "2.9.0",
  "com.github.pureconfig" %% "pureconfig" % "0.11.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "com.typesafe.play" %% "play-mailer" % "8.0.1",
  "com.typesafe.play" %% "play-mailer-guice" % "8.0.1"
)

      