class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(!stack.isEmpty() && stack.peek().equals(map.get(ch))){
                    stack.pop();
                }else{
                    return false;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
            
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;

    }
}