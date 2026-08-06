import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int ca : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && ca < 0 && stack.peek() > 0) {

                if (Math.abs(ca) == stack.peek()) {
                    destroyed = true;
                    stack.pop();
                    break;
                } else if (Math.abs(ca) > stack.peek()) {
                    stack.pop();
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ca);
            }
        }

        int[] res = new int[stack.size()];

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}