import java.util.{Locale, Date}
import java.text.DateFormat._

/**
 * Created by zhaow on 2014/12/1.
 */
object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world!")
    val now = new Date();
    val df = getDateInstance(LONG, Locale.CHINESE)
    println(now);
    println (df.format(now))

    val s1="kk JACK wHite"
    println (s1.contains("JACK"))
  }
}
