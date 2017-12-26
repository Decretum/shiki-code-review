package complete;

import java.util.Arrays;

/**
 * @author 戴世琦 on 12/23/2017
 * @project shiki-code-review
 */

/*
It seems that it is not to check between pair of strings but on all the strings in the array.

For example:

1. {"a","a","b"} should give "" as there is nothing common in all the 3 strings.

2. {"a", "a"} should give "a" as a is longest common prefix in all the strings.

3. {"abca", "abc"} as abc

4. {"ac", "ac", "a", "a"} as a.
 */


/*
the first solution came out by me, referring solutions provided by leetcode.
its runtime ranked at beating 11%..
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }
        return longestCommonPrefix(strs, 0, length - 1);
    }

    public String longestCommonPrefix(String[] strs, int begin, int end) {
        if (begin == end) {
            return strs[begin];
        } else {
            int mid = begin + (end - begin) / 2;
            String leftstr = longestCommonPrefix(strs, begin, mid);
            String rightstr = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(leftstr, rightstr);
        }
    }

    public String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) == right.charAt(i)) {
                sb.append(left.charAt(i));
                continue;
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}

// TODO george i just want to show you 2 ways.
/*
Another method my classmate shared with me
its runtime ranked at beating 50%
 */
class LongestCommonPrefix2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        int max = 0;
        int i; // TODO george because i used it after the for loop.
        int end =  Math.min(strs[0].length(), strs[strs.length - 1].length());
        for (i = 0; i <end; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
        }
        if (max < i) { //TODO george here i used "i"
            max = i;
        }
        return strs[0].substring(0, max);
    }

}
