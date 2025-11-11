
class Pair{
    int a,b;
    // a-zero,b-one
    Pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        ArrayList<Pair> l = new ArrayList<>();
        for(String st: strs){
            int a = 0;
            int b = 0;
            for(int i=0;i<st.length();i++){
                if(st.charAt(i) == '0') a++;
                else b++;
            }
            l.add(new Pair(a,b));
        }

        int prev[][] = new int[m+1][n+1];
        for(int i=1;i<=l.size();i++){
            int curr[][] = new int[m+1][n+1];
            int x = l.get(i-1).a;
            int y = l.get(i-1).b;
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int take =0;
                    if(j>=x && k>=y){
                        take = 1 + prev[j-x][k-y];
                    }
                    int nottake = prev[j][k];
                    curr[j][k] = Math.max(take,nottake);
                }
               
            }
            prev = curr;
        }
        return prev[m][n];
    }
}