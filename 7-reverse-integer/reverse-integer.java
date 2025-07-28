class Solution {
    public int reverse(int x) {
        //check leetcode sync
       int rev=0;
       while(x!=0){
        int digit = x%10;
        x=x/10;
        if(rev > Integer.MAX_VALUE/10 ||
        (rev==Integer.MAX_VALUE/10 &&digit>7)||
        rev<Integer.MIN_VALUE/10 ||
        (rev==Integer.MIN_VALUE/10 &&digit>8)
        ){
            return 0;
        }
        rev=rev*10+digit;
       }
       return rev;
    }
}