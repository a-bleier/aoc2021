package aoc

import scala.List


object Aoc03 {
    def run(lines : Iterator[String]) {
        val bitsList = lines.toList
        val countOnes = bitsList.map(_.split("").map(_.toInt)).transpose.map(_.sum)
        val gammaRate = countOnes.map(x => if(bitsList.length - x < x) 1 else 0).map(_.toString).mkString
        val epsilonRate = countOnes.map(x => if(bitsList.length - x > x) 1 else 0).map(_.toString).mkString
        println("Part one: " + Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2))
        val oxyCriteria = (data: List[Int]) =>{ if(data.length - data.sum <= data.sum) 1 else 0}
        val co2Criteria = (data: List[Int]) =>{ if(data.length - data.sum > data.sum) 1 else 0}
        println("Part two " + filterStuff(bitsList, oxyCriteria, 0) * filterStuff(bitsList, co2Criteria, 0) )
    }

    def filterStuff(data: List[String], criteria: (List[Int] => Int ), pos: Int): Int = {
        if(data.length == 1){
            return Integer.parseInt(data(0), 2)
        }
        val code = data.map(_.split("").map(_.toInt)).transpose.map(criteria(_))
            .map(_.toString).mkString
        filterStuff(data.filter(s => s(pos) == code(pos)), criteria, pos+1)
    }


}
