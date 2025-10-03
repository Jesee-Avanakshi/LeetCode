class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int res = 0;
        leftMax[0] = 0;
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        rightMax[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }

        for( int i=0;i<n;i++){
            int minimum =  Math.min(leftMax[i],rightMax[i]);
            System.out.println("For index : "+ i);
            System.out.println("Minimum :" + minimum);
            System.out.println("height :" + height[i]);
            if(height[i]<minimum){
                res= res + (minimum-height[i]);
                System.out.println(res);
            }
            System.out.println("result : "+ res);

        }
        return res;
    }
}