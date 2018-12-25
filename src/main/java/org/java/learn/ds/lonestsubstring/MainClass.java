package org.java.learn.ds.lonestsubstring;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duqi
 * @createTime 2018-12-25 10:41
 **/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int max = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (maps.containsKey(s.charAt(right))) {
                left = Math.max(left, maps.get(s.charAt(right)) + 1);
            }
            maps.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JSONArray.parseObject(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);

            int ret = new Solution().lengthOfLongestSubstring(line);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
