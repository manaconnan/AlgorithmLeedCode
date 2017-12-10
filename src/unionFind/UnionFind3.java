package unionFind;

public class UnionFind3 {

    private int[] parent;
    private int[] rank; //rank[i]表示以i为根的集合中的层数
    private int count;

    public UnionFind3(int count){
        this.count = count;
        parent = new int [count];
        rank = new int[count];
        for(int i = 0;i<count;i++){
            parent[i]=i;
            rank[i] = 1;
        }
    }
    public int find(int p){
        assert (p>=0&&p<count);
        while (p!=parent[p]){ //找到p的根节点
            parent[p] = parent[parent[p]]; //实现路径压缩， 只需要这一句话
            p = parent[p];

        }
        return p;
    }

    public boolean isConnected(int p , int q){
        return find(p)==find(q);
    }

    public void unionElements(int p , int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(qRoot==qRoot)
            return;
        //为了使新生成的并查集的数尽量矮一些 ，所以将元素层数较少的集合连接在元素层数较多的集合父节点下
        if(rank[pRoot]<rank[qRoot]) {
            parent[pRoot] = qRoot;
        }else if (rank[pRoot]>rank[qRoot]){
            parent[qRoot] = pRoot;
        }else { //rank[pRoot]==rank[qRoot]的情况
            parent[qRoot] = pRoot;
            parent[pRoot]+=1;
        }
    }
}
