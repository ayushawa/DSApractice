class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int j=0;
        int i=0;
        while(i<nums.length){
            sum += nums[i];
            while(sum * (i-j+1)>=k){
                sum -= nums[j];
                j++;
            }
            if(sum != 0 ){
                count += i-j+1;
            }
            i++;
        }
        return count;
    }
}