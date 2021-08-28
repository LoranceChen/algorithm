package huawei;

public class HuaWei0815Java {
    public static void main(String[] args) {
        System.out.println(desc("43", "32"));
        System.out.println(desc("223", "32"));
        System.out.println(desc("2023", "32"));
        System.out.println(desc("1023", "32"));
        System.out.println(desc("10023", "32"));
        System.out.println(desc("203", "32"));
        System.out.println(desc("203", "0"));
        System.out.println(desc("203", "200"));
    }

    public static String desc(String left,
                              String right) {
        if(left.length() < right.length() ||
                left.length() == 0 ||
                right.length() == 0
        ) throw new RuntimeException("fail input");

        String rst = descHelper(left, right, false, "");
        String remove0Rst = rst;
        // 去除前缀
        for (int i = 0; i < rst.length(); i++) {
            if(rst.charAt(i) != '0') {
                remove0Rst = rst.substring(i);
                break;
            }
        }

        return remove0Rst;
    }

    // 大整数相减
    public static String descHelper(String left,
                                    String right,
                                    Boolean tempUsed,
                                    String rst) {
        if(left.length() == 0 || right.length() == 0) {
            if(left.length() != 0) {
                if(tempUsed) {
                    // 处理边界情况：right没有，left有
                    if(left.length() == 1) {
                        String leftRstOne = String.valueOf(Integer.valueOf(left.substring(left.length() - 1)) - 1);
                        return leftRstOne +
                                rst;
                    } else { // 处理 20023 - 32 => "200", "", true, "91" => 199 91
                        String leftRst = "";
                        for (int i = left.length() - 1; i >= 0; i--) {
                            if(i == 0) {
                                String tmp = String.valueOf(Integer.valueOf(String.valueOf(left.charAt(0))) - 1);
                                leftRst = tmp + leftRst;
                                break;
                            }
                            if(left.charAt(i) == '0') { // 当前依然为0，继续循环处理
                                leftRst = "9" + leftRst;
                            } else {
                                leftRst = leftRst.substring(0, i) +
                                        String.valueOf(Integer.valueOf(String.valueOf(left.charAt(i))) - 1) + leftRst;

                                break;
                            }
                        }

                        return leftRst + rst;
                    }
                } else{
                    return left + rst;
                }
            } else {
                return rst;
            }
        }

        // 处理减法
        String subLeftString = left.substring(left.length() - 1);
        Integer curLeftCount = Integer.valueOf(subLeftString);

        String subRightString = right.substring(right.length() - 1);
        Integer curRightCount = Integer.valueOf(subRightString);
        Integer curRst = 0;

        if(tempUsed) { // 前面一次减法出现了借位
            curRst = 10 + curLeftCount - 1 - curRightCount;
        } else {
            curRst = 10 + curLeftCount - curRightCount;
        }

        if(curRst < 10) { // 借位了
            return descHelper(left.substring(0, left.length() - 1),
                    right.substring(0, right.length() - 1),
                    true,
                    curRst.toString() + rst);
        } else { // 没有借位
            return descHelper(left.substring(0, left.length() - 1),
                    right.substring(0, right.length() - 1),
                    false,
                    String.valueOf(curRst - 10) + rst);
        }

    }
}
