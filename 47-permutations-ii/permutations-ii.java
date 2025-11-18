class Solution {
    public void swap(List<Integer> l,int i,int j){
        int temp = l.get(i);
        l.set(i,l.get(j));
        l.set(j,temp);
      
    }
    public void helper(List<Integer> l,int i , List<List<Integer>> ans){
        if(i == l.size()){
            System.out.println(l);
            if(!ans.contains(l)) ans.add(new ArrayList<>(l));
            return;
        }
        for(int j=i;j<l.size();j++){
            swap(l,i,j);
            helper(l,i+1,ans);
            swap(l,i,j);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> l =new ArrayList<>();
        for(int x: nums) l.add(x);
        helper(l,0,ans);
        return ans;
    }
}