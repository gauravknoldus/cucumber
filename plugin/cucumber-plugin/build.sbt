name := "cucumber-plugin"

organization := "com.waioeka.sbt"

sbtPlugin := true

version := "0.1.5"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq (
	"io.cucumber" % "cucumber-core" % "2.0.0-SNAPSHOT",
	"io.cucumber" %% "cucumber-scala" % "2.0.0-SNAPSHOT",
	"io.cucumber" % "cucumber-jvm" % "2.0.0-SNAPSHOT" artifacts Artifact("cucumber-jvm", `type`="pom", extension="pom"),
	"io.cucumber" % "cucumber-junit" % "2.0.0-SNAPSHOT",
	"org.apache.commons" % "commons-lang3" % "3.5")


pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/lewismj/cucumber</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:lewismj/cucumber.git</url>
    <connection>scm:git:git@github.com:lewismj/cucumber.git</connection>
  </scm>
  <developers>
    <developer>
      <id>lewismj</id>
      <name>Michael Lewis</name>
      <url>http://www.waioeka.com</url>
    </developer>
  </developers>)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
