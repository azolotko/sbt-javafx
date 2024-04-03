name := "sbt-javafx"

organization := "nl.zolotko"

homepage := Some(url("https://quadstingray.github.io/sbt-javafx/"))

scmInfo := Some(ScmInfo(url("https://github.com/azolotko/sbt-javafx"), "https://github.com/azolotko/sbt-javafx.git"))

developers := List(
  Developer("QuadStingray", "QuadStingray", "github@quadstingray.com", url("https://github.com/QuadStingray")),
  Developer("Alex Zolotko", "azolotko", "azolotko@gmail.com", url("https://github.com/azolotko"))
)

licenses += ("Apache-2.0", url("https://github.com/azolotko/sbt-javafx/blob/master/LICENSE"))

description := "Sbt plugin for building JavaFx Applications"

publishMavenStyle := false

ThisBuild / bintrayReleaseOnPublish := true

scalaVersion := crossScalaVersions.value.last

crossScalaVersions := List("2.12.19")

scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-Ywarn-unused", "-Yrangepos")

crossSbtVersions := Vector("1.9.9")

console / initialCommands := "import com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.14"

resolvers ++= Resolver.sonatypeOssRepos("releases")

resolvers += Resolver.jcenterRepo

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations.*

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies, // : ReleaseStep
  inquireVersions, // : ReleaseStep
  setReleaseVersion, // : ReleaseStep
  commitReleaseVersion, // : ReleaseStep, performs the initial git checks
  tagRelease, // : ReleaseStep
  publishArtifacts,
  setNextVersion, // : ReleaseStep
  commitNextVersion, // : ReleaseStep
  pushChanges // : ReleaseStep, also checks that an upstream branch is properly configured
)
