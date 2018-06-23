package leetcode

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
object LongestSubstring extends App {
  /**
    * 遍历一遍s，记录当前最长的子字符串和最大数，遍历到空之止，返回当前的最大数即可
    */
  def lengthOfLongestSubstring(s: String): Int = {
    lengthOfLongestSubstringHelper(s, "", 0)
  }

  def lengthOfLongestSubstringHelper(s: String, curLongStr: String, curMax: Int): Int = {
    if(s.isEmpty) {
      curMax
    } else {
      val first = s.head

      var i = 0
      var matchFlag = false
      var subStr = curLongStr
      while(i < curLongStr.length && !matchFlag) {
        if (curLongStr(i) == first) {
          val (_, b) = curLongStr.splitAt(i + 1)
          subStr = b
          matchFlag = true
        }
        i += 1
      }

      val newLongStr = if(!matchFlag) curLongStr + first else subStr + first
      val newCurMax = if(curMax > newLongStr.length) curMax else newLongStr.length
      lengthOfLongestSubstringHelper(s.tail, newLongStr, newCurMax)

    }
  }

  println(lengthOfLongestSubstring("1231234456789"))
}
