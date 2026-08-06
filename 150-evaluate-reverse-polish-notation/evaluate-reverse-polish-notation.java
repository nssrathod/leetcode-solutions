class Solution {
    public int evalRPN(String[] tokens) {
        List<String> op = Arrays.asList("+","-","*","/");
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(!op.contains(token)){
                stack.push(Integer.parseInt(token));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                switch(token){
                    case "+" : c = a + b;
                    break;
                    case "-" : c = a - b;
                    break;
                    case "*" : c = a * b;
                    break;
                    case "/" : c = a / b;
                    break;
                    
                }
                stack.push(c);
            }
        }
        return stack.pop();
    }
}