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

    public int findUltimateParent(int node,int parent[]){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findUltimateParent(parent[node],parent);
        return parent[node];
    }

    public void UnionByRank(int node1,int node2){
        int ultimateParent1 = findUltimateParent(node1,parent);
        int ultimateParent2 = findUltimateParent(node2,parent);

        if(ultimateParent1 == ultimateParent2) return ;
        int rank1  = rank[ultimateParent1];
        int rank2 = rank[ultimateParent2];

        if(rank1>rank2){
            parent[ultimateParent2] = ultimateParent1;
        }else if(rank1<rank2){
            parent[ultimateParent1] = ultimateParent2;
        }else {
            parent[ultimateParent2] = ultimateParent1;
            rank[ultimateParent1]++;
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n= stones.length;
        int row = 0;
        int col = 0;
        for(int i=0;i<stones.length;i++){
             row  = Math.max(row,stones[i][0]);
            col  =Math.max(col,stones[i][1]);
        }
        row++;
        col++;
        DisjointSet djs = new DisjointSet(row+col);
        Map<Integer,Integer> StoneNodes = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            int r = stones[i][0];
            int c = row +stones[i][1];
            djs.UnionByRank(r,c);
            StoneNodes.put(r,1);
            StoneNodes.put(c,1);
        }
        int count =0;// no of component 
        for(Integer key : StoneNodes.keySet()){
            if(djs.findUltimateParent(key,djs.parent) == key) count++;
        }
        return n - count ; 
    }
}