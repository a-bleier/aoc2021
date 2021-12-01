import aoc.Aoc01

import scala.io.Source

object Main {
    def main(args: Array[String]): Unit ={
        Aoc01.run(readAocInput("aoc01.txt"))
    }

    def readAocInput(path: String) : Iterator[String] = {
        val source = Source.fromFile(path)
        val ret = source.getLines()
        return ret
    }
}
