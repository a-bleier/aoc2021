import aoc.{Aoc01, Aoc02, Aoc03}

import scala.io.Source

object Main {
    def main(args: Array[String]): Unit ={
        Aoc03.run(readAocInput("aoc03.txt"))
    }

    def readAocInput(path: String) : Iterator[String] = {
        val source = Source.fromFile(path)
        val ret = source.getLines()
        ret
    }
}
