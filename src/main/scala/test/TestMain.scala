package test

object TestMain {
  def main(args: Array[String]): Unit = {
    val lst = List(1,2,3)
    (0 until 10) foreach(item => {
      println(item)
    })

    println(lst.drop(1))
    val lsts = List(List(1,2,3), List(4,5,6))
    val flatMaped = lsts.flatMap(a => a)
    println(flatMaped)

    val forRst = for{
      ll <- lsts
      item <- ll
      if item % 2 == 0
    } yield {
      item
    }

    lsts.flatMap(ll => {
      ll.map(item => {
        item
      })
    })

//    forRst.avg

    println(s"forRst: $forRst")

  }


}
