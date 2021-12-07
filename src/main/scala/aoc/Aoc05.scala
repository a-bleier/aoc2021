package aoc

object Aoc05 {
    def run(lines: Iterator[String]): Unit = {

        val tuples = lines.toList.map(_.split(" -> ").toList.map(_.split(",").toList.map(_.toInt)).map {
            case List(a, b) => (a, b)
        })
        val horizontalPipes = tuples.filter(con => con(0)._1 == con(1)._1 || con(0)._2 == con(1)._2)
        println(horizontalPipes)
    }

    def check1(pipes: List[List[(Int,Int)]], crossings: Int): Int = {
        if(pipes.length == 1){
            return crossings
        }
        val curr = pipes.head
        val toInspect = pipes.slice(1, pipes.length)
        val crossed = toInspect.filter(p => twoPipesCrossed1(curr, p))
        return check1(toInspect, crossings + crossed.length)
    }

    def twoPipesCrossed1(pipe1: List[(Int, Int)], pipe2: List[(Int, Int)]): Boolean = {
        if(pipe1(0)._1 == pipe1(1)._1){ //First pipe vertical
            if(pipe2(0)._1 == pipe2(1)._1){ //second pipe vertical
//                return  pipe1(0)._1 == pipe2(0)._1 && ()
            } else { //horizontal

            }
        } else { //First is horizontal
            if(pipe2(0)._1 == pipe2(1)._1){ //second pipe vertical

            } else { //horizontal

            }
        }
        return false
    }
}
