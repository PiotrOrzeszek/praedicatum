name := "Spark2.0-and-greater"

version := "1.0"

//Older Scala Version
scalaVersion := "2.11.8"

val overrideScalaVersion = "2.11.8"
val sparkVersion = "2.0.0"
val sparkXMLVersion = "0.3.3"
val sparkCsvVersion = "1.4.0"
val sparkElasticVersion = "2.3.4"
val sscKafkaVersion = "1.6.2"
val sparkMongoVersion = "1.0.0"
val sparkCassandraVersion = "1.6.0"

//Override Scala Version to the above 2.11.8 version
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

resolvers ++= Seq(
  "All Spark Repository -> bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"
)

libraryDependencies ++= Seq(
  "org.apache.spark"      %% "spark-core"       % sparkVersion  exclude("jline", "2.12"),
  "org.apache.spark"      %% "spark-sql"        % sparkVersion excludeAll(ExclusionRule(organization = "jline"),ExclusionRule("name","2.12")),
  "org.apache.spark"      %% "spark-hive"       % sparkVersion,
  "org.apache.spark"      %% "spark-yarn"       % sparkVersion,
  "com.databricks"        %% "spark-xml"        % sparkXMLVersion,
  "com.databricks"        %% "spark-csv"        % sparkCsvVersion,
  "org.apache.spark"      %% "spark-graphx"     % sparkVersion,
  "org.apache.spark"      %% "spark-catalyst"   % sparkVersion,
  "org.apache.spark"      %% "spark-streaming"  % sparkVersion,
  //  "com.101tec"           % "zkclient"         % "0.9",
  "org.elasticsearch"     %% "elasticsearch-spark"        %     sparkElasticVersion,
  "org.apache.spark"      %% "spark-streaming-kafka"     % sscKafkaVersion,
  "org.mongodb.spark"      % "mongo-spark-connector_2.11" %  sparkMongoVersion,
  "com.stratio.datasource" % "spark-mongodb_2.10"         % "0.11.1",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  "com.google.protobuf" % "protobuf-java" % "2.6.1",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0" % "test" classifier "models",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"

  // Adding this directly as part of Build.sbt throws Guava Version incompatability issues.
  // Please look my Spark Cassandra Guava Shade Project and use that Jar directly.
  //"com.datastax.spark"     % "spark-cassandra-connector_2.11" % sparkCassandraVersion

)
//
//
//organization := "databricks"
//
//version := "1.0"
//
//scalaVersion := "2.10.4"
//
////crossScalaVersions := Seq("2.11.8", "2.10.6")
////crossScalaVersions := Seq("2.11.8", "2.10.6")
//
//initialize := {
//  val _ = initialize.value
//  val required = VersionNumber("1.8")
//  val current = VersionNumber(sys.props("java.specification.version"))
//  assert(VersionNumber.Strict.isCompatible(current, required), s"Java $required required.")
//}
//
//sparkVersion := "2.0.0"
//
//// change the value below to change the directory where your zip artifact will be created
//spDistDirectory := target.value
//
//spAppendScalaVersion := true
//
//credentials += Credentials(Path.userHome / ".ivy2" / ".sbtcredentials")
//
//sparkComponents += "sql"
//
//// add any sparkPackageDependencies using sparkPackageDependencies.
//// e.g. sparkPackageDependencies += "databricks/spark-avro:0.1"
//spName := "databricks/spark-corenlp"
//
//licenses := Seq("GPL-3.0" -> url("http://opensource.org/licenses/GPL-3.0"))
//
//resolvers += Resolver.mavenLocal
//
//libraryDependencies ++= Seq(
//  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
//  "com.google.protobuf" % "protobuf-java" % "2.6.1",
//  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0" % "test" classifier "models",
//  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
//"org.apache.spark" % "spark-core_2.10" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
//"org.apache.spark" % "spark-sql_2.10" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
//"org.apache.hadoop" % "hadoop-common" % "2.7.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
//"org.apache.spark" % "spark-sql_2.10" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
//"org.apache.spark" % "spark-hive_2.10" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
//"org.apache.spark" % "spark-yarn_2.10" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")
//
//)
