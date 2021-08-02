package niuke

object LongestCommonString {

  def main(args: Array[String]): Unit = {

//    val rst = LCS("1NY92514w8AF5q1sul7MVNFZnGengc03vO912lFftHDkWpMwWN0SY4pXO1QLji18ujkZV4vr449Wo495WOyIXiO4C9M5L7hQ4tX9ePvV5ohnX00e4mOW28xO968cdR266Ej5M",
    (0 until 2000).foreach(x => {
      val begin = System.nanoTime()
//      val rst = LCS("\"u738sE8YS6h6kuy5HgBPMJwk09tLf6a6934QxntO1FOUR9nUaOt6d783xte8wkt28fMttWqpC6l12y51McN7GUC5036hJk4n64IZko1Y9nR4WmV6qaWf17I52P6mv418H9i7QEcB8COvdYuyP6GtmY1N1B9g0CqA9ApiARAR726Md5uZkMUM7WG7FQ8aJgY45F0KkTdV65oNuaX67c0543bS1J2JpKmamg93Rqf4u8l6mRenVtmCP44RE816AUB5662E3DrRPCUR33y94NSaI7yp13NwbvpFVbuQaMGtE5Y43uPxsYt2M8X4az16m1DA44qkR94Gr9asxlJjlhe7o4tA3q24IrJOA77ADap3ERC71EspC2iNTl47DarHZj8bV7D92g2i66e7AYok6UJfrV0s8h4dF240JypwJ42Hqs41Ah5Xvh0d923VgC26FXB8lw33SUxgPzGEo9pQ85X3UW5j7KVuAY704H8sr59miS2VIn3TFPRm3z9zR35AG48d6P34P6DQLyaWaBh9ac3L6zn0YFyfuJ6azvo01BB6D9pTIu0CnH94UI6F3m8RMVB2y657330ojdzaDN382TUaswy8Kp1ih63847Ss7Bv27T8DBBWV2zye2r04CiXvSQt4nXU26901g62iHXxXPt6036MKfgP52deALiW5760q400P2oOSrdgfIJ9IPm9eNneg3RH1EtATiw997Nl3D9u53akabOenB5iLsVp29u73Y0m84gI5LS4medbw92n4WC88Q781hO552q28d3W0gBWFb5GlNlb56z08vEd5gkbQ52yDlVm10T0UGZ6dwd4QZgGL4DG014cIP62lWY6cR1lZDuzaUWA83hmcu710WMxQ25vnhGy96j6przx4fz1WBqG1TJIcSKmziQ5ZEN5zm3JUWy4m669Oknz231TSZ01xo156IOvEj449LqjJhB7heihG5iWZko5jbZKT8m7FIP5aE55pq1QqT158m2Y6W1BYx2QkN2BQXmJW0WBioG5X7bN8qK3dOnE0EuO71OKigS0a6k7fK7A7Z3lPPPGiruD0n31h2VwItpL7e7PSlS54CWPweiv6zXrU410GtLzQZb8vS6vkRMq2836p6mo18M2OmA6oz40cS9a425j22hu28J4Qf3Fq9Bhv3yGVMx12v8teZ4VkXOT3yBAmfF8RKHPS9Y2bQ4hmTkaPXtU59j3T7HHEp1NSgst0XxN2r2ovVFo19psRNl9mbauJmEhhTIZtk1G1SsGp89d6jpMmfAVRO3jam1w165Z0y6s4gO4K05OgN2KW0zGFlQM75Jf15Rf2LDngt469SB6Hxq93fKT0cYuZ424pf3xe8Cv2xLf9Go51s4c64lrP20W62VL48EvBaL3yg9OeUl0qryFq7januHZZbGRUykWdQ8BsPO9VMcYF4AFk2i2k3QTPTy3L1k91w44r9tT6Rce0CEKWk5Y36cWTJWh14k21VQh3HST4uU7B1Ik8uNbJWSjX8gQoU8s364hVCYhY6Bxlc96YX6CBQi7ai07Eoyog1c5YFLzmCSNZ25lTa8hw9O13r0G99vB37PvrhinjH2VUg8pdXM6iCoLBo3Tn397i3Rad3Km71i9tucqEynJWpqX9yi2Z2OpCkdi18HYzGo78hjSIC37HFwyU792FTp5N4tSZl9ii1RB2qkbKgAJ7UYO3vXgwE7Ji4BigcpD5rB6MNg4sPPdxb4B0bO7ky7YcyT2b27sYt7LSHRs3pI9w6BJtCjgDn85d7Qt2UL8J49h13BcSELs6AgC6AxEomLa65wFHNPZTO2G1FR6p159QDvoR969K2EKOKH3xwer66KN0fB85IDhL0Jdc896NPCF3ucyd7jFdWowYuAGcsxQkf9K5M5vXY5x507t87C79yYeX8T7ez0DbV2nFhW9Vbm10V4kfU9PvG1yXfgqGOH14tD2hW5l27EFyDmMR46Y8lLIaD7rKtaR857G7v8SyX28RL86d293", "Y5x507t87C79yYeX8T7ez0DbV2nFhW9Vbm10V4kfU9PvG1yXfgqGOH14tD2hW5l27EFyD")
      val rst = LCS("22222", "22222")
      val end = System.nanoTime()
      println(s"time cost: ${(end - begin) / 1000000.0} ms") // 2.513351
      println(rst)
    })

  }

  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    * longest common substring
    * @param str1 string字符串 the string
    * @param str2 string字符串 the string
    * @return string字符串
    */
  def LCS(str1: String,str2: String): String = {
    // write code here
    LCSHelper(str1, str2, 0, 0, 0, Nil, Nil).mkString
  }

  def LCSHelper(str1: String, str2: String,
                str1GroupIndex: Int,
                str1Index: Int, str2Index: Int,
                maxRst: List[Char],
                curRst: List[Char]): List[Char] = {
    if(str1GroupIndex > str1.length - 1) {
      if(maxRst.length >= curRst.length) maxRst else curRst
    } else if(str1Index > str1.length - 1) {
      LCSHelper(str1, str2, str1GroupIndex + 1, str1GroupIndex + 1,
        0, if(maxRst.length >= curRst.length) maxRst else curRst,
        Nil)
    } else if(str2Index > str2.length - 1) {
      LCSHelper(str1, str2, str1GroupIndex + 1, str1GroupIndex + 1,
        0, if(maxRst.length >= curRst.length) maxRst else curRst,
        Nil)
      // if(maxRst.length > curRst.length) maxRst else curRst
    } else {
      if(str1(str1Index) == str2(str2Index)) { // 当前index值匹配
        LCSHelper(str1, str2, str1GroupIndex, str1Index + 1,
          str2Index + 1, maxRst, curRst :+ str1(str1Index))
      } else { // 当前index值不匹配
        if(str1GroupIndex == str1Index) { // str2第一次就匹配失败
          LCSHelper(str1, str2,
            str1GroupIndex, str1GroupIndex, // str1基于当前从group头开始
            str2Index + 1, // str2从下一个元素开始比较
            if (maxRst.length >= curRst.length) maxRst else curRst, // 更新最大串
            Nil // 当前比较从0开始
          )
        } else { // str2 匹配过程中失败
          LCSHelper(str1, str2,
            str1GroupIndex, str1GroupIndex, // str1基于当前从group头开始
            str2Index, // str2从下一个元素开始比较
            if (maxRst.length >= curRst.length) maxRst else curRst, // 更新最大串
            Nil // 当前比较从0开始
          )
        }
      }
    }
  }
}