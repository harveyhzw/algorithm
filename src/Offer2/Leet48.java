package Offer2;

import java.util.HashSet;
import java.util.Set;

/*
最长不含重复字符的子字符串
 */
public class Leet48 {

    public static void main(String[] args) {

        System.out.println("abcabcbb:" + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:" + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew:" + lengthOfLongestSubstring("pwwkew"));
        System.out.println("qrsvbspk:" + lengthOfLongestSubstring("qrsvbspk"));

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int appear[]  = new int[128];

        int start = 0;
        int end = 0;
        int maxLen = 0;

        int strLen = s.length();
        while(end < strLen) {
            if(appear[s.charAt(end)] == 1 ) {
                while(s.charAt(start) != s.charAt(end)) {
                    appear[s.charAt(start)] = 0;
                    start++;
                }
                appear[s.charAt(start)] = 0;
                start++;
            }

            appear[s.charAt(end)] = 1;

            if(end-start+1 > maxLen)
                maxLen = end-start+1;
            end++;
        }

        return maxLen;

    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Set<Character> subStrings = new HashSet<>();

        int start = 0;
        int end = 0;
        int maxLen = 0;

        int strLen = s.length();
        while(end < strLen) {
            if(subStrings.contains(s.charAt(end))) {
                while(s.charAt(start) != s.charAt(end)) {
                    subStrings.remove(s.charAt(start));
                    start++;
                }
                subStrings.remove(s.charAt(start));
                start++;
            }

            subStrings.add(s.charAt(end));

            if(subStrings.size() > maxLen)
                maxLen = subStrings.size();
            end++;
        }

        return maxLen;

    }
}
