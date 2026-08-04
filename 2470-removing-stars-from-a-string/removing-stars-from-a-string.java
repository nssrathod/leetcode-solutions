class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        for (char ch : stack) {
            res.append(ch);
        }
        return res.toString();
    }
}