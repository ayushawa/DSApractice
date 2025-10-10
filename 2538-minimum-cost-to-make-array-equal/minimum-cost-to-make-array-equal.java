class Solution {
    public long findCost(int arr[],int costs[],int m){
        long cost  = 0;
        for(int i=0;i<arr.length;i++){
            cost +=(long) costs[i]*Math.abs((long)m-(long)arr[i]);
        }
        return cost;
    }
    public long minCost(int[] nums, int[] costs) {
        long cost = (long)1e14;
        int s =Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;
        for(int x:  nums){
            s = Math.min(s,x);
            e = Math.max(e,x);
        }
        long ans = 0;
        while(s<e){
            int m = s + (e-s)/2;
            long c1  = findCost(nums,costs,m);
            long c2 = findCost(nums,costs,m+1);
            if(c1<=c2){
                e =  m;
            }
            else s =  m+1;
        }
        return findCost(nums,costs,s);
    }
}