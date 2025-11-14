class DisjointSet{
    int parent[];
    int rank[];
    DisjointSet(int node){
        parent = new int[node];
        rank = new int[node];
        for(int i=0;i<node;i++){
          parent[i] = i;
        }
    }

    public int  findUltimateParent(int node,int parent[]){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findUltimateParent(parent[node],parent);
        return parent[node];
        
    }

    public void UnionByRank(int node1,int node2){
        int ultimateParent1 = findUltimateParent(node1,parent);
        int ultimateParent2 = findUltimateParent(node2,parent);

        if(ultimateParent1 == ultimateParent2) return;

        int rank1 = rank[ultimateParent1];
        int rank2 = rank[ultimateParent2];
        if(rank1 >rank2){
            parent[ultimateParent2] = ultimateParent1;
        }
        else if(rank1 < rank2){
            parent[ultimateParent1] = ultimateParent2;
        }
        else {
            parent[ultimateParent2] = ultimateParent1;
            rank[ultimateParent1]++;
        }
    }


}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String,Integer> map = new HashMap<>();
        DisjointSet dsu = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s = accounts.get(i).get(j);
                if(!map.containsKey(s)){
                    map.put(s,i);
                }
                else {
                    dsu.UnionByRank(i,map.get(s));
                }
            }
        }

        List<List<String>> l = new ArrayList<>();
        for(int i =0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(String key : map.keySet()){
            int parentof = dsu.findUltimateParent(map.get(key),dsu.parent);
            l.get(parentof).add(key);
        }

        int i = 0;
        int ind = 0;
        while(i<l.size()){
            if(l.get(i).size() != 0){
                Collections.sort(l.get(i));
                l.get(i).add(0,accounts.get(ind).get(0));
                i++;
                ind++;
            }else {
                l.remove(i);
                ind++;
            }
        }
        return l;

    }
}