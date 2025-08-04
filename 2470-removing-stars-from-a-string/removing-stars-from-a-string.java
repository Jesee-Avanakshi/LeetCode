class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        String newS ="";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='*'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            newS = stack.pop() + newS;
        }
        return newS;

    }
}