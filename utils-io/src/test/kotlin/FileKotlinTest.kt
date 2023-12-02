import org.wdt.utils.io.readFileToString
import org.wdt.utils.io.toFile

fun main() {
	val file = "./Test.txt".toFile()
	// Test.txt : Hello World
	println(file.readFileToString())
	// Out : Hello World
}