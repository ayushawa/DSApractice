class Solution {
    public int minCost(String colors, int[] time) {
       int ans =0;
       int last = time[0];
       for(int i=1;i<colors.length();i++){
          if(colors.charAt(i) == colors.charAt(i-1)){
            if(time[i]>=last){
                ans += last;
                last = time[i];
            }else {
                ans += time[i];
            }
          }
          else {
            last = time[i];
          }
       }
       return ans;
    }
}