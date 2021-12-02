package aoc

object Aoc02 {
    def run(lines : Iterator[String]) {
        val cmds = lines.toArray
        val pos = calcPosition(cmds, Pos(0,0))
        println("Part one " + pos.x * pos.y)
        val pos2 = calcPosition(cmds, Pos2(0,0,0))
        println("Part two " + pos2.x * pos2.y)
    }

    def calcPosition(cmds : Array[String], pos: Pos): Pos ={
        val line = cmds(0).split(" ")
        val change = calcChangeFromCmd(line(0), line(1).toInt)
        if(cmds.length == 1){
            return Pos(pos.x + change.x, pos.y + change.y)
        }
        return calcPosition(cmds.slice(1, cmds.length), Pos(pos.x + change.x, pos.y + change.y))
    }

    def calcPosition(cmds : Array[String], pos: Pos2): Pos2 ={
        if(cmds.length == 0){
            return pos
        }
        val line = cmds(0).split(" ")
        calcPosition(cmds.slice(1, cmds.length), calcChangeFromCmd(line(0), line(1).toInt, pos))
    }


    def calcChangeFromCmd(cmd : String, num : Int): Pos = cmd match {
        case "forward" => Pos(num, 0)
        case "up" => Pos(0, -num)
        case "down" => Pos(0, num)
    }

    def calcChangeFromCmd(cmd : String, num : Int, pos : Pos2): Pos2 = cmd match {
        case "forward" => Pos2(pos.x+num, pos.y+num*pos.aim, pos.aim)
        case "up" => Pos2(pos.x, pos.y, pos.aim-num)
        case "down" => Pos2(pos.x, pos.y, pos.aim + num)
    }


}

case class Pos (x: Int, y: Int)
case class Pos2 (x: Int, y: Int, aim: Int)