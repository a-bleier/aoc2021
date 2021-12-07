package aoc

object Aoc06 {
    def run(lines: Iterator[String]): Unit = {
        val line = lines.toList
        val lanternFishs = line(0).split(",").map(_.toLong).toList
        println("Part 1: " + simulate(lanternFishs, 80))
        val lfMap = lanternFishs.groupBy(identity).map(p => (p._1, p._2.length.toLong)) + (6L->0L) + (7L -> 0L) + (8L -> 0L) + (0L -> 0L)
        println("Part 2: " + simulateFaster(lfMap, 256))
    }

    def simulateFaster(lfs: Map[Long, Long], days: Int): Long = {
        if(days == 0){
            return lfs.values.sum
        }
        val newGen = Map(
            8L -> lfs(0),
            0L -> lfs(1),
            1L -> lfs(2),
            2L -> lfs(3),
            3L -> lfs(4),
            4L -> lfs(5),
            5L -> lfs(6),
            6L -> (lfs(7) + lfs(0)),
            7L -> lfs(8)

        )
        return simulateFaster(newGen, days-1)
    }

    def simulate(lfs: List[Long], days: Int): Long = {
        if(days == 0){
            return lfs.length
        }
        val altered = lfs.map(x => x-1)
        val count = altered.count(x => x == -1)
        val newGen = altered.map(x => if (x==(-1) ) 6L else x.toLong ) ++ List.fill(count)(8L)
        return simulate(newGen, days-1)
    }
}
