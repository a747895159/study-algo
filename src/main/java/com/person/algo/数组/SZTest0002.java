package com.person.algo.数组;

/**
 *
 * @author : ZhouBin
 */
public class SZTest0002 {


    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(repeatedSubstringPattern2("aa"));
    }


    public static boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

}
