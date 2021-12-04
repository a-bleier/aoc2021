package aoc

object Aoc04 {
    def run(lines: Iterator[String]): Unit = {
        //prepare input
        val cleared = lines.toList.filter(x => x != "")
        val nums = cleared.head.split(",").toList
        val boards = cleared.slice(1, cleared.length).grouped(5).toList.map(_.map(_.split(" ").filter(_.nonEmpty).toList))
        println("part one: " + play(boards, nums))
        println("part two: " + play2(boards, nums, List.fill(boards.size)(-1)))
    }
    def play2(boards: List[List[List[String]]], nums: List[String], oldSums: List[Int]): Int = {
        val curr = nums.head
        val newBoards = boards.map(_.map(_.map(x => if (x == curr) "x" else x)))
        val finishedSums = check(newBoards)
        if (finishedSums.count(_ != -1) == boards.size) {
            val number = finishedSums.zip(oldSums).filter(p => p._1 != p._2 && p._2 == -1).unzip._1.head
            return number * nums.head.toInt
        }
        play2(newBoards, nums.slice(1, nums.length), finishedSums)
    }
    def play(boards: List[List[List[String]]], nums: List[String]): Int = {
        val curr = nums.head
        val newBoards = boards.map(_.map(_.map(x => if (x == curr) "x" else x)))
        val unmarked = check(newBoards).filter(_ != -1)
        if (unmarked.nonEmpty) {
            return unmarked.head * nums.head.toInt
        }
        return play(newBoards, nums.slice(1, nums.length))
    }

    def check(boards: List[List[List[String]]]): List[Int] = {

        val checkOneBoard: (List[List[String]] => Int) = (board: List[List[String]]) => {
            val xRowCounts = board.map(_.count(x => x == "x"))
            val xColCounts = board.transpose.map(_.count(x => x == "x"))
            if (xRowCounts.contains(5)) {
                val index = xRowCounts.indexOf(5)
                val noWinningLine = board.zipWithIndex.collect{case (a,i) if i != index => a}.map(_.filter(_ != "x"))
                noWinningLine.map(_.map(_.toInt).sum).sum
            } else if (xColCounts.contains(5)) {
                val index = xColCounts.indexOf(5)
                val noWinningLine = board.transpose.zipWithIndex.collect{case (a,i) if i != index => a}.map(_.filter(_ != "x"))
                noWinningLine.map(_.map(_.toInt).sum).sum
            } else {
                -1
            }
        }
        return boards.map(checkOneBoard(_))
    }
}
