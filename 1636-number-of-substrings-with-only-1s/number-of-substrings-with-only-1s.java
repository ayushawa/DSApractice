class Solution {
    public int numSub(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int count = 0;
        int mod = (int)1000000007;
        while(i<n){
            char ch = s.charAt(i);
            if(ch == '1'){     
                count = (count + i-j+1)%mod;
            }
            else j = i+1;
            i++;
        }
        return count;
    }
}