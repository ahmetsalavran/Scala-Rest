name := """deneme"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.6"
scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
    // Enable reactive mongo for Play 2.8
    "org.reactivemongo" %% "play2-reactivemongo" % "0.20.13-play28",
    // Provide JSON serialization for reactive mongo  
    "org.reactivemongo" %% "reactivemongo-play-json-compat" % "1.0.1-play28",
    // Provide BSON serialization for reactive mongo  
    "org.reactivemongo" %% "reactivemongo-bson-compat" % "0.20.13",
    // Provide JSON serialization for Joda-Time
    "com.typesafe.play" %% "play-json-joda" % "2.7.4",

    

)