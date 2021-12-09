package aoc
/*
 0: 6 beinhaltet im ggs zu 6 die 1
 1: 2 -
 2: 5 bleibt übrig
 3: 5 hat alle der sieben
 4: 4 -
 5: 5 fünf gleiche zur neun
 6: 6 bleibt übrig
 7: 3 -
 8: 7 -
 9: 6 hat alle der vier

 */
object Aoc08 {
    def run(lines: Iterator[String]): Unit = {
        val prep = lines.toList.map(_.split(" \\| ").toList).transpose;
        val patterns = prep(0)
        val values = prep(1)
        println("Part one: " + values.map(_.split(" ").count(s => List(2,3,4,7).contains(s.length))).sum)
        val patternsSorted = patterns.map(_.split(" ").toList.map(_.split("").sorted.toList.mkString))
        val valuesSorted = values.map(_.split(" ").toList.map(_.split("").sorted.toList.mkString))
        println("Part two: " + sum(patternsSorted, valuesSorted))
    }

    //Expects the segment cables in each pattern to be alphabetically sorted
    def sum(patterns: List[List[String]], values: List[List[String]]): Int = {
        val lookup = getLookup(patterns.head)
        val result = values.head.map(s => lookup(s)).mkString.toInt
        if(patterns.length == 1){
            return result
        }
        return result + sum(patterns.slice(1, patterns.length), values.slice(1, values.length))
    }

    def getLookup(sortedPatterns: List[String]): Map[String, String] = {
        val one = sortedPatterns.find(_.length == 2).get
        val four = sortedPatterns.find(_.length == 4).get
        val seven = sortedPatterns.find(_.length == 3).get
        val eight = sortedPatterns.find(_.length == 7).get
        val nine = sortedPatterns.find( s => s.length == 6 && containsAllCharsOf(s, four)).get
        val zero = sortedPatterns.find( s => s.length == 6 && s != nine && containsAllCharsOf(s, one)).get
        val six = sortedPatterns.find( s => s.length == 6 && s != nine && s != zero).get
        val three = sortedPatterns.find( s => s.length == 5 && containsAllCharsOf(s, seven)).get
        val five = sortedPatterns.find( s => s.length == 5 && s != three && containsAllCharsOf(six, s)).get
        val two = sortedPatterns.find( s => s.length == 5 && s != three && s != five).get

        val ret = Map(zero -> "0", one -> "1", two -> "2", three -> "3", four -> "4", five -> "5", six -> "6", seven -> "7", eight -> "8", nine -> "9")
        ret
    }

    def containsAllCharsOf(a: String, b: String): Boolean = {
        b.forall(a.toSet)
    }

}
