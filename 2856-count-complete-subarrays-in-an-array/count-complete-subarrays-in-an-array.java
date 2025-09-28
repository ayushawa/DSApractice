class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x: nums){
            st.add(x);
        }
        int size = st.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int n = nums.length;

        int j=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.size() == size){
                count += (n-i);
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                }
                j++;
            }
        }
        return count;

        
    }
}