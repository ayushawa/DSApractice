class Solution {
    public int numberOfBeams(String[] bank) {
        int count =0;
        int prev = 0;
        
        for(String s: bank){
            int curr =0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '1') curr++;
            }
            if(curr >0){
                count += prev*curr;
                prev = curr;
            }
        }

        return count;
    }
}