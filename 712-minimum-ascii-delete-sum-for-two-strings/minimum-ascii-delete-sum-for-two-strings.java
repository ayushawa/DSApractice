class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<n;i++) sum1 += s1.charAt(i)-'a'+97;
        for(int j=0;j<m;j++) sum2 += s2.charAt(j)-'a'+97;
        int prev[] = new int[m+1];
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] += s1.charAt(i-1)-'a'+97  + prev[j-1];
                }
                else {
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
            }
            prev = curr;
        }

        return sum1 + sum2 - 2*prev[m];
    }
}