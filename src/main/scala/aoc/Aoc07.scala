package aoc

object Aoc07 {
    def run(lines: Iterator[String]): Unit = {
        val positions = lines.toList(0).split(",").map(_.toLong).toList
        println("Part one: " + calcLineup(positions,0L, -1L, Long.MaxValue, identityCost))
        println("Part two: " + calcLineup(positions,0L, -1L, Long.MaxValue, incrementalCost))
    }

    def calcLineup(lineup: List[Long], currPos: Long, bestPos: Long, bestCost: Long, costFunc: (Long, Long) => Long): Long= {
        val cost = lineup.map(x => costFunc(x, currPos)).sum
        val newBestPos = if(cost < bestCost) currPos else bestPos
        val newBestCost = if(cost < bestCost) cost else bestCost
        if(currPos == lineup.max){
            return newBestCost
        }
        return calcLineup(lineup, currPos+1, newBestPos, newBestCost, costFunc)
    }

    def identityCost(x: Long, y: Long): Long = {
        return Math.abs(x-y)
    }
    def incrementalCost(x: Long, y: Long): Long = {
        val n = Math.abs(x-y)
        return n * (n+1) / 2
    }

}
