package binarySearchTree;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree<T> {

    private Node<T> root ;
    private int count;



    public BinarySearchTree(){
        root=null;
        count=0;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }

    public void insert(int key,T value){

        Node<T> node = new Node<T>(key,value);

        if(root==null){
            root = node;
            count++;
            return;
        }else {
            insert(root,node);
        }

    }
    private <T> void insert(Node<T> root, Node<T> node){

        if(node.getKey() == root.getKey()){
            root.setValue(node.getValue());
        }else if(node.getKey()>root.getKey()){
            if(root.getRight()==null){
                root.setRight(node);
                count++;
            }else {
                insert(root.getRight(), node);
            }
        }else {
            if(root.getLeft()==null){
                root.setLeft(node);
                count++;
            }else {
                insert(root.getLeft(),node);
            }
        }
        
    }

    

    public Node<T> getNodeByKey(int key){
        
        return findNode(root,key);
    }
    
    private Node<T> findNode(Node<T> node,int key){
        
        if(key==node.getKey()){
            return node;
        }
        if(key> node.getKey()){
            return findNode(node.getRight(),key);
        }
        if(key<node.getKey()){
            return findNode(node.getLeft(),key);
        }
        
        return null;
    }
    /**
     * 根据传入的键查找元素
     * @param key
     * @return
     * @throws Exception
     */
    public T getValue(int key) throws Exception {
        
        Node<T> node =  searchNode(root,key);
        if (node!=null){
            return node.getValue();
        }else {
          throw new Exception("没有该键");
        }
    }

    public List<Node<T>> getPreOder(){
        List<Node<T>> nodeList = new ArrayList<>();
        getNodePreOder(root,nodeList);
        return nodeList;
        
    }
    public List<Node<T>> getInoder(){

        List<Node<T>> nodeList = new ArrayList<>();
        getNodeInOder(root,nodeList);
        return nodeList;

    }
    public List<Node<T>> getPostOder(){

        List<Node<T>> nodeList = new ArrayList<>();
        getNodePostOder(root,nodeList);
        return nodeList;

    }

    public List<Node<T>> getLevelOder(){

        List<Node<T>> nodeList = new ArrayList<>();
        getNodeLevelOder(root,nodeList);
        return nodeList;

    }
    
    public Node<T> getMin(){
        Node<T> node = root;

//        while (true){
//            node = node.getLeft();
//            if(node.getLeft()==null){
//                return node;
//            }
//        }

        return getMinNode( node );

    }
    public Node<T> getMax(){
        Node<T> node = root;
        while (true){
            node = node.getRight();
            if(node.getRight()==null){
                return node;
            }
        }
    }

    /**
     * 找到以node为根节点的二分搜索树的最小节点
     * @param node
     * @return 最小的节点
     */
    private Node<T> getMinNode(Node<T> node){

        if(node.getLeft()==null){
            return node;
        }
        return getMinNode(node.getLeft());
    }

    private Node<T> getMaxNode(Node<T> node){
        if(node.getRight()==null){
            return node;
        }
        return getMaxNode(node.getRight());
    }
    public void removeMin(){

        if(root!=null) {
            root = removeMin(root);// 删除最左侧的节点之后， 可能还有树，直接接到跟节点
                                    //删除之后， 得到一个全新的root
        }
    }

    public void removeMax(){
        if(root!=null){
            root = removeMax(root);
        }
    }

    /**
     * 删除任意一个节点
     * @param key
     */
    public void remove(int key){

        if(root!=null){
            root = remove(root,key);
        }
        
    }

    public Node<T> findFloor(int key){

        if(findNode(root,key)!=null){
            return findNode(root,key);
        }else {
            return null;//TODO
        }
    }

    /**
     *
     * @param node
     * @param key
     * @return 返回被删除指定节点之后的，新的二叉树的跟节点
     */
    private Node<T> remove(Node<T> node,int key){

        if(node==null){
            return null;
        }
        if(key<node.getKey()){
            Node<T> tNode = remove(node.getLeft(), key);
            node.setLeft(tNode);
            return node; //一定要理解其中递归的原理
        }else if (key>node.getKey()){
            Node<T> tNode = remove(node.getRight(), key);
            node.setRight(tNode);
            return node;
        }else { //key == node.getKey()的情况 ,需要删除该node节点
            if(node.getLeft()==null){

                count--;
                return node.getRight(); //隐式的把当前节点删除了， 将该节点的右孩子返回给了删除节点的父亲

            }
            if(node.getRight()==null){
                count --;
                return node.getLeft();
            }

            //重点： 如果待删除节点的左右两个孩子都不为空 这里是 hubbard deletion算法
            //将 待删节点右子树的最小节点代替当前节点
            Node<T> newNode = getMinNode(node.getRight());

            Node<T> rightNode = removeMin(node.getRight()); //删除右孩子的最小节点， 也就是newNode，返回的是新树的根节点

            newNode.setRight(rightNode); //  将新树的根节点作为新节点的右孩子

            newNode.setLeft(node.getLeft());// 将原来节点的左孩子继续作为新节点的左孩子

            return newNode;
        }


    }

    private Node<T> removeMax(Node<T> node){

        if(node.getRight()==null){
            Node<T> leftNode = node.getLeft();
            count--;
            return leftNode;
        }
        Node<T> temNode = removeMax(node.getRight());

        node.setRight(temNode);

        return node;
    }

    /**
     *  TODO 这段代码没理解
     * @param note
     * @return
     */
    private Node<T> removeMin(Node<T> note){

        if(note.getLeft()==null){
            Node<T> nodeRight = note.getRight();//这是一个删除操作 ,即使这里rightNode为null也没有关系
            count--;
            return nodeRight;
        }
        Node<T> newNode = removeMin(note.getLeft());

        note.setLeft(newNode) ; //删除最左侧节点（最小值），如果这个最左侧节点有右孩子，则用右孩子代替被删除的节点

        return note;
    }


    /**
     *  用到队列， 钥匙看不懂的话， 查资料， 看视频
     * @param node
     * @param list
     */
    private void getNodeLevelOder(Node<T> node,List<Node<T>> list){
        Queue<Node<T>> nodeQueue = new ArrayDeque<>();

        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()){

            Node<T> tNode = nodeQueue.poll();
            list.add(tNode);
            if(tNode.getLeft()!=null){
                nodeQueue.add(tNode.getLeft());

            }
            if(tNode.getRight()!=null){
                nodeQueue.add(tNode.getRight());
            }
        }

    }
    private void getNodePreOder(Node<T> node,List<Node<T>> list){
        
        if (node!=null){
            list.add(node);
            getNodePreOder(node.getLeft(),list);
            getNodePreOder(node.getRight(),list);

        }else {
            return;
        }

    }
    private void getNodeInOder(Node<T> node,List<Node<T>> list){
        if(node!=null){
            getNodeInOder(node.getLeft(),list);
            list.add(node);
            getNodeInOder(node.getRight(),list);
        }
    }
    private void getNodePostOder(Node<T> node,List<Node<T>> list){
        if(node!=null){
            getNodeInOder(node.getLeft(),list);
            getNodeInOder(node.getRight(),list);
            list.add(node);
        }
    }
    private <T> Node searchNode(Node<T> root, int key){
        
        if (root.getKey()==key){
            return new Node(key,root.getValue());
        }
        
        if(root.getKey()>key){
            return  searchNode(root.getLeft(),key);
        }
        if(root.getKey()<key){
            return searchNode(root.getRight(),key);
        }
        
        return null;
    }

    public static void main(String[] args) {

        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert(5,"v5" );
        tree.insert(2,"v2");
        tree.insert(8,"v8");
        tree.insert(6,"v6");
        tree.insert(10,"v10");
        tree.insert(3,"v3");
        tree.insert(1,"v1");
        tree.insert(11,"v11");
        tree.insert(9,"v9");
        tree.insert(7,"v7");

        List<Node<String>> nodes = tree.getInoder();
        for(Node n : nodes){
            System.out.print(n.getValue()+" ");
        }
        System.out.println();


        tree.remove(8);

        nodes = tree.getInoder();
        for(Node n : nodes){
            System.out.print(n.getValue()+" ");
        }
        System.out.println();
        nodes = tree.getPreOder();
        for(Node n : nodes){
            System.out.print(n.getValue()+" ");
        }

        nodes = tree.getLevelOder();
        System.out.println();
        for(Node n : nodes){
            System.out.print(n.getValue()+" ");
        }

        System.out.println(tree.count);
    }

}
