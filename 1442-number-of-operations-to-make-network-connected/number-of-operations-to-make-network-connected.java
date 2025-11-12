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

    public int findParent(int node,int parent[]){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node],parent);
        return parent[node];
    }

    public  boolean isExtra(int node1,int node2){
        return findParent(node1,parent) == findParent(node2,parent);
    }

    public void unionByRank(int node1,int node2){
        int parent1 = findParent(node1,parent);
        int parent2  = findParent(node2,parent);
        if(parent1 == parent2) return ;

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];
        if(rank1 > rank2){
            parent[parent2] = parent1;
        }
        else if(rank1< rank2){
            parent[parent1] = parent2;
        }
        else {
            parent[parent2] = parent1;
            rank[parent1]++;
        }
    }

    public int ConnectedComponent(){
        int count = 0;
        for(int i=0;i<parent.length;i++){
            if(parent[i] == i) count++;
        }

        return count;
    }
}
class Solution {
    public int makeConnected(int n, int[][] edges) {
        int extraEdge= 0;
        
        DisjointSet dsg = new DisjointSet(n);
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
    

            if(dsg.isExtra(u,v)) {
                extraEdge++;
            }
            else {
                dsg.unionByRank(u,v);
            }
        }
        int ans = dsg.ConnectedComponent()-1;
        if(extraEdge>=ans) return ans;
        else return -1;
        
    }
}