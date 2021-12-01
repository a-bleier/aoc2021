package aoc

object Aoc01 {
    def run(lines : Iterator[String]) {
        val depths = lines.toArray.map(_. toInt)
        println("Part1: " + countIncreasingValues(depths))
        println("Part2: " + countIncreasingWindows(depths))
    }

    def countIncreasingValues(depths : Array[Int]): Int={
        if(depths.length == 2) {
            return if (depths(0) < depths(1)) 1 else 0
        } else {
            return countIncreasingValues(depths.takeRight(depths.length-1)) + (if (depths(0) < depths(1)) 1 else 0)
        }
    }

    def countIncreasingWindows(depths : Array[Int]): Int={
        val w1 = depths.slice(0,3).sum
        val w2 = depths.slice(1,4).sum
        val ret = if(w1 < w2) 1 else 0
        if(depths.length <= 4) {
            return ret
        } else {
            return ret + countIncreasingWindows(depths.slice(1,depths.length))
        }
    }
}
