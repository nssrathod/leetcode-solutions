import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        boolean[] status = new boolean[n];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } 
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    status[i] = true;
                }
            }
        }

        // Mark unmatched '('
        while (!stack.isEmpty()) {
            status[stack.pop()] = true;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!status[i]) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}