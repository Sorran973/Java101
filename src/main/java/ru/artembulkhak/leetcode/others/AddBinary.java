package ru.artembulkhak.leetcode.others;

/**
 * https://leetcode.com/problems/add-binary/description/
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int min, max;
        String minStr, maxStr;
        if (a.length() > b.length()) {
            minStr = b;
            maxStr = a;
            min = b.length() - 1;
            max = a.length() - 1;
        } else {
            minStr = a;
            maxStr = b;
            max = b.length() - 1;
            min = a.length() - 1;
        }

        int first;
        int second;
        int carry = 0;
        while (max >= 0) {
            if (min < 0) {
                first = 0;
            } else {
                first = minStr.charAt(min) - '0';
            }
            second = maxStr.charAt(max) - '0';
            int res = first + second + carry;
            switch (res) {
                case 0 -> stringBuilder.append(0);
                case 1 -> {
                    stringBuilder.append(1);
                    carry = 0;
                }
                case 2 -> {
                    stringBuilder.append(0);
                    carry = 1;
                }
                case 3 -> {
                    stringBuilder.append(1);
                    carry = 1;
                }
            }

            max--;
            min--;
        }

        if (carry == 1) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
//        System.out.println(new AddBinary().addBinary("1010", "1011"));

    }
}
