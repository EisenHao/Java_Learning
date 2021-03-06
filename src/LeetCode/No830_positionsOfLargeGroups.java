package LeetCode;

import java.util.ArrayList;
import java.util.List;

/** utf-8
 * Leetcode
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 *
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 *
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 *
 * coder:eisenhao
 * Java
 * 20190402
 * */

class No830_positionsOfLargeGroups {
    static class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            int len = S.length(), start_i = 0;
            char lastCh = ' ', ch;
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            ;

            for (int i = 0; i < len; i++) {
                ch = S.charAt(i);
                if (ch != lastCh) {
                    //判断长度
                    if (i - start_i > 2) {
                        //添加到结果中
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(start_i);
                        tmp.add(i - 1);
                        result.add(tmp);
                    }
                    //更新
                    lastCh = ch;
                    start_i = i;
                }
            }
            //判断结尾
            if (len - start_i > 2) {
                //添加到结果中
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(start_i);
                tmp.add(len - 1);
                result.add(tmp);
            }
            return result;
        }
    }

    /**
     * Test
     * */
    public static void main(String[] args) {
        Solution s = new Solution();
        String Input = "abcdddeeeeaabbbcd";

        System.out.println("Output = ");
        System.out.println(s.largeGroupPositions(Input));
    }
}

