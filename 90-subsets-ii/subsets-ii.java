class Solution {
    public void helper(int arr[],int i,List<Integer> l,List<List<Integer>> ans){
        if(i == arr.length){
            if(!ans.contains(l)){
                ans.add(new ArrayList(l));
            }
            return;
        }

        helper(arr,i+1,l,ans);
        l.add(arr[i]);
        helper(arr,i+1,l,ans);
        l.remove(l.size()-1);
    
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> l =new ArrayList<>();
        helper(nums,0,l,ans);
        return ans;
    }
}