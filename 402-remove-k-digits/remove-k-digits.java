class Solution {
    public String removeKdigits(String num, int k) {

        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;

        // remove the k digit 
        for (int i = 0; i < num.length(); i++) {

            while (!stack.isEmpty() && stack.peek() > num.charAt(i)) {
                if (count < k) {
                    stack.poll();
                    count++;
                }else break ;
            }

            stack.push(num.charAt(i));
        }

        // remove the remainging digit .. 
        while (count < k) {
            stack.pop();
            count++;
        }
        if (stack.isEmpty())
            return "0";

        // create the ans string and appen char 
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }


        // remove lead zero 
        int indx = 0;
        while (indx < sb.length()-1  && sb.charAt(indx) == '0') {
            indx++;
        }

        return sb.toString().substring(indx);
    }
}