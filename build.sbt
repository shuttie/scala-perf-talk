jmhSettings

name := "scalabench"

version := "1.0"

scalaVersion := "2.12.0-SNAPSHOT"

scalaHome := Some(file("/home/shutty/code/scala/build/pack"))

//scalaVersion := "2.11.4"

//scalacOptions ++= Seq("-Ybackend:GenBCode", "-optimize", "-Yopt:l:classpath", "-Xexperimental")

//scalacOptions += "-print"

//javaOptions += "-XX:MaxInlineSize=300"

//javaOptions += "-XX:FreqInlineSize=300"

//javaOptions += "-XX:InlineSmallCode=300"

//javaOptions += "-XX:LoopUnrollLimit=0"

javaOptions += "-server"