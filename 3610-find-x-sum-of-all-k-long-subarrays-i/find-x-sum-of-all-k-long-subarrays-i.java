class Pair{
    int fr,el;
    Pair(int fr,int el){
        this.fr = fr;
        this.el = el;
    }
}
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p,y)->p.fr == y.fr?p.el-y.el:p.fr-y.fr);
        int sum = 0;
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum += nums[i];
        }
        for(Integer key : map.keySet()){
            pq.add(new Pair(map.get(key),key));
            if(pq.size()>x) pq.poll();
        }
        if(pq.size()== x){
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                ans[0] += p.fr * p.el;
            }
        }
        else ans[0] = sum;
        pq.clear();
        int j=1;
        for(int i=k;i<n;i++){
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum += nums[i] -nums[i-k];

            for(Integer key: map.keySet()){
                pq.add(new Pair(map.get(key),key));
                if(pq.size()>x) {   
                    pq.poll();
                }
            }

            if(pq.size() == x){
                while(!pq.isEmpty()){
                    Pair p= pq.poll();
                    ans[j] += p.fr*p.el;
                }
            }
            else ans[j] = sum;
            j++;
            pq.clear();
        }
        return ans;

    }
}