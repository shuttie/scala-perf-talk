jmhSettings

name := "scalabench"

version := "1.0"

scalaVersion := "2.11.4"

scalacOptions += "-optimize"

libraryDependencies += "com.github.scala-blitz" %% "scala-blitz" % "1.1"

//javaOptions += "-XX:MaxInlineSize=150"

//javaOptions += "-XX:FreqInlineSize=150"

//javaOptions += "-XX:InlineSmallCode=150"