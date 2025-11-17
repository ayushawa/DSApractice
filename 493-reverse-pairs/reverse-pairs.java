class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
    public int merge(int nums[],int l,int r){
        if(l>=r) return 0;
        int m = l + (r-l)/2;

        int count = merge(nums,l,m);
        count+= merge(nums,m+1,r);
        count+= countPair(nums,l,m,r);
        
        mergeArray(nums,l,m,r);
        return count;
    }

    public void mergeArray(int arr[],int l,int m,int r){
        List<Integer> temp = new ArrayList<>();
        int i = l;
        int j = m+1;

        while(i<=m && j<=r){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else {
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=m) {
            temp.add(arr[i]);
            i++;
        }
        while(j<=r){
            temp.add(arr[j]);
            j++;
        }

        for(int k=0;k<temp.size();k++){
            arr[l+k] = temp.get(k);
        }

    }

    public int countPair(int arr[],int l,int m,int r){
        int count = 0;
        int j= m+1;

        for(int i=l;i<=m;i++){
            while(j<=r && arr[i]> 2L * arr[j]){
                j++;
            }
            count += (j - (m + 1));

        }
        return count;
    }
}