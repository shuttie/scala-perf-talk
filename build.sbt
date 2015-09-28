enablePlugins(JmhPlugin)

name := "scalabench"

version := "1.0"

//scalaVersion := "2.12.0-M2"

//scalaHome := Some(file("/home/shutty/code/scala/build/pack"))

scalaVersion := "2.11.7"

//scalacOptions ++= Seq("-Ybackend:GenBCode", "-optimize", "-Yopt:l:classpath", "-Xexperimental")

scalacOptions += "-print"

//javaOptions += "-XX:LoopUnrollLimit=0"

//javaOptions += "-XX:+UnlockDiagnosticVMOptions"

//javaOptions += "-XX:+PrintInlining"

//javaOptions += "-Djmh.perfasm.assemblySyntax=intel"

//javaOptions += "-XX:MaxInlineSize=300"

//javaOptions += "-XX:FreqInlineSize=300"

//javaOptions += "-XX:InlineSmallCode=300"

//javaOptions += "-XX:LoopUnrollLimit=1"

resolvers += "bintray/non" at "http://dl.bintray.com/non/maven"

//libraryDependencies += "org.spire-math" %% "debox" % "0.7.0"

//libraryDependencies += "org.openjdk.jmh" % "jmh-core" % "1.8"

//libraryDependencies += "org.openjdk.jmh" % "jmh-generator-asm" % "1.8"

//libraryDependencies += "org.openjdk.jmh" % "jmh-generator-bytecode" % "1.8"

//libraryDependencies += "org.openjdk.jmh" % "jmh-generator-reflection" % "1.8"

libraryDependencies += "com.github.scala-blitz" % "scala-blitz_2.11" % "1.2"