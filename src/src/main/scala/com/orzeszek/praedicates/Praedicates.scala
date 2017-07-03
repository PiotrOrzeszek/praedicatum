package com.orzeszek.praedicates

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import com.databricks.spark.corenlp.functions._
import com.orzeszek.praedicates.Praedicates
//import com.orzeszek.praedicates.Praedicates.sqlContext
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark._
/**
  * Created by piotr on 02/07/17.
  */

object Praedicates {
  //  @transient var sc: SparkContext = _
  //  @transient var sqlContext: SQLContext = _


  def main(args: Array[String]) {
    //    val logFile = "/Users/piotr/Development/spark-1.6.1-bin-hadoop2.4/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    //    val logData = sc.textFile(logFile, 2).cache()
    ////    val numAs = logData.filter(line => line.contains("a")).count()
    ////    val numBs = logData.filter(line => line.contains("b")).count()
    //    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))

    val sqlContext: SQLContext = SQLContext.getOrCreate(sc)

    val text = "If you’re like me when I was a kid, you might be disappointed to find that the lions and tigers don’t fight"
    val df = sqlContext.createDataFrame(Seq((0, text))).toDF("id", "input")
    val actual = df.select(ssplit(col("input"))).first().get(0)
    println("=================================================================")
    println(actual)
    println("=================================================================")
  }
}
