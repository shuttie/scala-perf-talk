enablePlugins(JmhPlugin)

name := "scalabench"

version := "1.0"

//scalaVersion := "2.12.0-RC2"

scalaVersion := "2.11.8"

//scalacOptions += "-print"

//javaOptions += "-XX:LoopUnrollLimit=0"

//javaOptions += "-XX:+UnlockDiagnosticVMOptions"

//javaOptions += "-XX:+PrintInlining"

//javaOptions += "-XX:MaxInlineSize=300"

//javaOptions += "-XX:FreqInlineSize=300"

//javaOptions += "-XX:InlineSmallCode=300"

//javaOptions += "-XX:LoopUnrollLimit=1"

resolvers += "bintray/non" at "http://dl.bintray.com/non/maven"

//libraryDependencies += "org.spire-math" %% "debox" % "0.7.0"

libraryDependencies += "com.github.scala-blitz" %% "scala-blitz" % "1.2"
