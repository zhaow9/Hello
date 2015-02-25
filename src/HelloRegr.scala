import java.util.{Locale, Date}
import java.text.DateFormat._

/**
 * Created by zhaow on 2014/12/1.
 */
object HelloRegr {
  def main(args: Array[String]) {
     println("Hello, world!")
     val str1 = """10.10.10.10 - "FRED" [18/Jan/2013:17:56:07 +1100] "GET http://images.com/2013/Generic.jpg
                 | HTTP/1.1" 304 315 "http://referall.com/" "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1;
                 | GTB7.4; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.04506.648; .NET CLR
                 | 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 1.0.3705; .NET CLR 1.1.4322; .NET CLR
                 | 3.5.30729; Release=ARP)" "UD-1" - "image/jpeg" "whatever" 0.350 "-" - "" 265 923 934 ""
                 | 62.24.11.25 images.com 1358492167 - Whatup""".stripMargin.lines.mkString

      println (str1)
//      println (str1)

    val apacheLogRegex =
      """^([\d.]+) (\S+) (\S+) \[([\w\d:/]+\s[+\-]\d{4})\] "(.+?)" (\d{3}) ([\d\-]+) "([^"]+)" "([^"]+)".*""".r

    apacheLogRegex.findFirstIn(str1) match {
      case Some(apacheLogRegex(ip, _, user, dateTime, query, status, bytes, referer, ua)) =>
        if (user != "\"-\"") println (ip, user, query)
        else (null, null, null)
      case _ => println (null, null, null)
    }

    val str2 = "[2015-01-1812:50:00] [webcontainer5] [processid]"
    println (str2)
    val netLogRegex = """(\[\S+\]) (\[\S+\]) (\[\S+\])""".r

    netLogRegex.findFirstIn(str2) match {
      case Some(netLogRegex(dateTime, threadId, processId)) =>
        println (dateTime, threadId, processId)
      case _ => println ("null")
    }


  }
}
