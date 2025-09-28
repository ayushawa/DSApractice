class Solution {
    public int[] getAverages(int[] nums, int k) {
       int n = nums.length;
       int k2 = 2*k +1;
       long sum = 0;
       int ans[] = new int[n];
       Arrays.fill(ans,-1);
       if(k>=nums.length || k2>n) return ans;
       int ind = k;
       System.out.println(k2);
       for(int i = 0;i<k2;i++){
        sum += nums[i];
       }   
       ans[ind++] = (int)(sum/k2);
       for(int i=k2;i<n;i++){
          sum = sum + nums[i] - nums[i-k2];
          ans[ind++] = (int)(sum/k2);
       }
       return ans;
    }
}