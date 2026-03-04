scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "pps-code-scala",
    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test
  )