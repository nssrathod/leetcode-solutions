class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!Character.isDigit(ch)){
                stack.push(ch);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        String res = "";
        for(char ch : stack){
            res += ch;
        }
        return res;
    }
}