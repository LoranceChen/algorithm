package huawei

object HuaWei0818 {
  def main(args: Array[String]): Unit = {
    assert(commonPrefix(List("abcd", "abcd", "abcdadsada")) == "abcd")
    assert(commonPrefix(List("abcd", "abc", "abcdadsada")) == "abc")
    assert(commonPrefix(List("abcd", "abcd", "abcd")) == "abcd")
    assert(commonPrefix(List("abcd", "a", "abcd")) == "a")
    assert(commonPrefix(List("", "abcd", "abcd")) == "")
    assert(commonPrefix(List()) == "")
    assert(commonPrefix(List("ab1", "abc")) == "")
  }

  // 找出多个字符串的公共前缀
  def commonPrefix(strs: List[String]): String = {
    if(strs.isEmpty) return ""
    // 包含非char数据
    if(strs.exists(str => str.exists(char => !char.isLetter))) return ""
    commonPrefixHelper(strs, "")
  }

  def commonPrefixHelper(strs: List[String], rst: String): String = {
    if(strs.contains("")) return rst
    val compareChar = strs.head.head
    var compareRst = true
    strs.foreach(str => {
      if(str.head != compareChar) {
        compareRst = false
      }
    })

    if(compareRst) {
      commonPrefixHelper(strs.map(str => str.tail), rst + compareChar.toString)
    } else {
      rst
    }
  }
}
