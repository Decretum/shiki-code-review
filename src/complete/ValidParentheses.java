package complete;


import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] parentheses = s.toCharArray();
        for (char c : parentheses) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (stack.empty() || stack.pop() != c) { // this step I took from other's
                return false;
            }
        }
        return stack.empty();
    }
}

//i came out with the same idea that using stack to deal with this problem
//but i had been stuck for a really long time, probably 1 hour.
//so i decided to take a look at "Discuss" and found this brilliant idea!