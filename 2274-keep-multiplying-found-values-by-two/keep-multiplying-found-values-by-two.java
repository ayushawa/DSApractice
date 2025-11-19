class Solution {
    public int findFinalValue(int[] nums, int or) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == or){
                or *= 2;
            }
        }
        return or;
    }
}