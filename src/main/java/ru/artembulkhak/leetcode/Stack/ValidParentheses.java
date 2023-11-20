package ru.artembulkhak.leetcode.Stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                return false;
            } else if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '('
                    || c == ']' && stack.peek() == '['
                    || c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid(""));
    }
}
