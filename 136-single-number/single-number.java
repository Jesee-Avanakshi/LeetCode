class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> hashmap =new HashMap<>();
        for(int num:nums){
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:hashmap.entrySet()){
            if(entry.getValue() ==1){
                return entry.getKey();
            }
        }
        return 0;
    }
}