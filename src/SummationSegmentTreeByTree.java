/**
 * implementation of Segment tree by tree that build the tree by the sum value
 * each node present the sum of the numbers under it
 */
public class SummationSegmentTreeByTree extends SegmentTreeByTree{

    /**
     * Constructor for creating a Segment Tree from an input array
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public SummationSegmentTreeByTree(int[] arr){
        super(arr);
    }


    /**
     * Queries the Segment Tree for the Sum value in the given range
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Sum value in the given range
     */
    public int queryRange(int left, int right) {
        SegmentTreeNode node = queryRangeHelper(root,left,right);
        return node.getSum();
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
            return "" + node.getSum() + " ";
        String current = "" + node.getSum() + " ";
        String left = recursiveToString((SegmentTreeNode)node.getLeft());
        String right = recursiveToString((SegmentTreeNode)node.getRight());
        return current+left+right;
    }




}
