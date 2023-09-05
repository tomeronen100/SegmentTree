/**
 * implementation of Segment tree by tree that build the tree by the minimum value
 * each node present the lowest numbers under it
 */
public class MinimumSegmentTreeByTree extends SegmentTreeByTree{

    /**
     * Constructor for creating a Segment Tree from an input array
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public MinimumSegmentTreeByTree(int[] arr){
        super(arr);
}

    /**
     * Queries the Segment Tree for the minimum value in the given range
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Minimum value in the given range
     */
    public int queryRange(int left, int right) {
        SegmentTreeNode node = queryRangeHelper(root,left,right);
        return node.getMin();
    }

    /**
     * toString that able to print the tree and his values according to this subclass
     * @return String - the tree
     */
    public String toString(){
        String sb = " [ ";
        SegmentTreeNode node = root;
        sb += recursiveToString(node);
        return sb + "] ";
    }


    /**
     * recursively build the tree and his values
     * @param node of the tree
     * @return String - the hole tree
     */
    public String recursiveToString(SegmentTreeNode node){
        if (node.getStart() == node.getEnd())
            return "" + node.getMin() + " ";
        String current = "" + node.getMin() + " ";
        String left = recursiveToString((SegmentTreeNode)node.getLeft());
        String right = recursiveToString((SegmentTreeNode)node.getRight());
        return current+left+right;
    }



}
