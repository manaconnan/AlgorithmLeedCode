package unionFind;

public class UnionFind {

    int[] id;
    int count;

    /**
     * 初始化总共n个数的并查集 ,初始时没个数字的id号均不一样，表示每个数字都没有连接，只有id相同的数字是连接的
     * @param n
     */
    public UnionFind(int n){
        count=n;
        id = new int[n];
        for (int i=0;i<n;i++){
            id[i]=i;
        }
    }

    public int  find(int p){
        assert(p>=0&&p<count);
        return id[p];
    }

    public boolean isConnected(int p, int q){
        return find(p)==find(q);
    }

    /**
     *  将两个元素联合， 那么必须让两个元素所在的组的所有元素的id都相等，所以要遍历一遍，时间复杂度O(N)
     * @param p
     * @param q
     */
    public void unionElements(int p , int q){
        int pId=find(p);
        int qId=find(q);
        if(pId==qId) return; //如果发现两个id已经相等， 说明这两个元素所在的组的id都已经相等了，所以不需要再union了

        for(int i = 0 ; i<count;i++){
            if(id[i]==pId)
                id[i]=qId;
        }

    }
}
