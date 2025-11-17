class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i  =0;
        int j=0;
        int n = nums.length;
        int start = 0;
        while(i<n){
            if(nums[i] == 1){
                if(start == 0 ) start = 1;
                else if(i-j<k) {
                   
                    return false;
                }
                j = i+1;
            }
            i++;
        }
        return true;
    }
}