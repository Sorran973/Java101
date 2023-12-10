package ru.artembulkhak.leetcode.TwoPointers;

/**
 * https://leetcode.com/problems/merge-strings-alternately/description/
 */

public class MergeStringsAlternately {
     public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        StringBuilder result = new StringBuilder();

        if (word1Length >= 1 && word2Length <= 100) {
            int i = 0;
            for (; i < word1Length; i++) {
                result.append(word1.charAt(i));

                if (i >= word2Length) {
                    continue;
                } else {
                    result.append(word2.charAt(i));
                }
            }

            while (i < word2Length) {
                result.append(word2.charAt(i));
                i++;
            }

            return result.toString();
        } else return result.toString();
    }

    public String mergeAlternatelyTwoPointersMyVersion(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int word1Len = word1.length();
        int word2Len = word2.length();
        int firstPointer = 0;
        int secondPointer = 0;

        boolean firstFlag;
        boolean secondFlag;
        while (true) {
            firstFlag = true;
            secondFlag = true;
            if (firstPointer < word1Len) {
                result.append(word1.charAt(firstPointer));
                firstPointer++;
                firstFlag = false;
            }
            if (secondPointer < word2Len) {
                result.append(word2.charAt(secondPointer));
                secondPointer++;
                secondFlag = false;
            }
            if (firstFlag && secondFlag) {
                return result.toString();
            }
        }
    }

    public String mergeAlternatelyTwoPointers(String word1, String word2) {
         StringBuilder result = new StringBuilder();
         int word1Len = word1.length();
         int word2Len = word2.length();
         int firstPointer = 0;
         int secondPointer = 0;

         while (firstPointer < word1Len || secondPointer < word2Len) {
             if (firstPointer < word1Len) {
                 result.append(word1.charAt(firstPointer));
                 firstPointer++;
             }
             if (secondPointer < word2Len) {
                 result.append(word2.charAt(secondPointer));
                 secondPointer++;
             }
         }

         return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MergeStringsAlternately().mergeAlternatelyTwoPointers("cqpqcnluezomtkvjprcqeaucgttwlpqeyfwenybcluxwzjvixlljn",
                "mpolktwnezewpiuwinsptbjqzplpeoeuwpehkycvrsslfznunjihtauplcipxmobnipqekegxmddzkepuqzoqepebgwmkuxipjbn"));

    }
}
