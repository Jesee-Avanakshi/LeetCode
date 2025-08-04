class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        for(int i=0;i<flowerbed.length;i++){
           //check if the current plot is empty
           if(flowerbed[i]==0){
            //check if left and right plots are empty
            Boolean leftPlot = (i==0) || flowerbed[i-1]==0;
            Boolean rightPlot = (i==flowerbed.length-1) || flowerbed[i+1]==0;
            if(leftPlot && rightPlot){
                flowerbed[i]=1;
                n--;
                if(n==0){
                    return true;
                }
            }
           } 
        }
        return false;
    }
}