import aoc.{Aoc01, Aoc02, Aoc03, Aoc04, Aoc05, Aoc06, Aoc07, Aoc08}

import scala.io.Source

object Main {
    def main(args: Array[String]): Unit ={
        Aoc08.run(readAocInput("aoc08.txt"))
    }

    def readAocInput(path: String) : Iterator[String] = {
        val source = Source.fromFile(path)
        val ret = source.getLines()
        ret
    }
}
