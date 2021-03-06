package com.exercises.leetcode.strings.medium;

//        --------------------------------------------------------------------------------------------------------------
//        Input: dead-ends = ["0201","0101","0102","1212","2002"], target = "0202"
//        Output: 6
//        Explanation:
//        A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//        Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//        because the wheels of the lock become stuck after the display becomes the dead end "0102".
//        --------------------------------------------------------------------------------------------------------------
//        Input: dead-ends = ["8888"], target = "0009"
//        Output: 1
//        Explanation:
//        We can turn the last wheel in reverse to move from "0000" -> "0009".
//        --------------------------------------------------------------------------------------------------------------
//        Input: dead-ends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
//        Output: -1
//        Explanation:
//        We can't reach the target without getting stuck.
//        --------------------------------------------------------------------------------------------------------------
//        Input: dead-ends = ["0000"], target = "8888"
//        Output: -1
//        --------------------------------------------------------------------------------------------------------------
//        Note:
//
//        The length of dead-ends will be in the range [1, 500].
//        target will not be in the list dead-ends.
//        Every string in dead-ends and the string target will be a string of 4 digits from the 10,000 possibilities
//        '0000' to '9999'.
//        --------------------------------------------------------------------------------------------------------------

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        Set<String> temp;
        while(!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for(String s : begin) {
                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level++;
            begin = temp;
        }
        return -1;
    }
}
