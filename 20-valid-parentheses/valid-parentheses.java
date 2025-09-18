class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char brace = s.charAt(i);
            if(map.containsKey(brace)){
                if(!stack.isEmpty() && stack.peek() == map.get(brace)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(brace);
            }
        }
        return stack.isEmpty();

    }
}