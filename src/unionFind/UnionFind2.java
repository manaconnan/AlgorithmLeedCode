package unionFind;

public class UnionFind2 {

    private int[] parent;
    private int[] sz; //sz[i]表示以i为根的集合中的元素个数
    private int count;

    public UnionFind2(int count){
        this.count = count;
        parent = new int [count];
        sz = new int[count];
        for(int i = 0;i<count;i++){
            parent[i]=i;
            sz[i] = 1;
        }
    }
    public int find(int p){
        assert (p>=0&&p<count);
        while (p!=parent[p]){ //找到p的根节点
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
        //为了使新生成的并查集的数尽量矮一些 ，所以将元素较少的集合连接在元素较多的集合父节点下
        if(sz[pRoot]<sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        }
    }
}
