class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(x,y)->x[0]!=y[0]?x[0]-y[0]:y[1]-x[1]);
        int n = arr.length;
        int height[] = new int[n];
        for(int i=0;i<n;i++){
            height[i] = arr[i][1];
        }

        List<Integer> lis =new ArrayList<>();
        for(int ele: height){
            int ind = Collections.binarySearch(lis,ele);
            if(ind<0) ind = -(ind+1);
            
            if(ind == lis.size()) lis.add(ele);
            else lis.set(ind,ele);
        }

        return lis.size();
    }
}

