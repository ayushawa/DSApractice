class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        left[0] = 1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                left[i] = left[i-1]+1;
            }
            else left[i] = 1;
        }

        int val = 1;
        int sum = 0;
        sum += Math.max(1,left[n-1]);
        val = Math.max(1,left[n-1]);

        for(int i= n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                left[i] = Math.max(left[i],1+val);
                val = left[i];
            }
            else val = 1;
            sum+=left[i];
            
        }
        return sum;
    }
}