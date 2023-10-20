import org.wdt.utils.io.readFileToString
import java.io.File

fun main() {
    val file = File("./Test.txt")
    // Test.txt : Hello World
    println(file.readFileToString())
    // Out : Hello World
}