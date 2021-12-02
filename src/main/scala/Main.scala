import aoc.{Aoc01, Aoc02}

import scala.io.Source

object Main {
    def main(args: Array[String]): Unit ={
        Aoc02.run(readAocInput("aoc02.txt"))
    }

    def readAocInput(path: String) : Iterator[String] = {
        val source = Source.fromFile(path)
        val ret = source.getLines()
        ret
    }
}
