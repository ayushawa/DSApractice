class Solution {
    public int longestOnes(int[] nums, int k) {
        int one = 0;
        int len = 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==1) one++;
            if(i-j+1 - one>k){
                if(nums[j] == 1) one--;
                j++;
            }
            len = Math.max(len,i-j+1);
        }
        return len;
    }
}