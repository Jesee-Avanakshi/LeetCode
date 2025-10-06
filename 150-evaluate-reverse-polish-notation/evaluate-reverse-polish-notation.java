class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s:tokens){
            if(!"+-*/".contains(s)){
                stack.push(Integer.valueOf(s));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            int result = 0;

            switch(s){
                case "+" : result = num1+num2;
                            break;
                case "-" : result = num1-num2;
                            break;
                case "*" : result = num1*num2;
                            break;
                case "/" : result = num1/num2;
                            break;
            }
            stack.push(result);
        }
        return stack.peek();
    }
}