/**
 * implementation of Segment tree by tree that build the tree by the maximum value
 * each node present the biggest numbers under it
 */

public class MaximumSegmentTreeByTree extends SegmentTreeByTree{

    /**
     * Constructor for creating a Segment Tree from an input array
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public MaximumSegmentTreeByTree(int[] arr){
        super(arr);
    }

    /**
     * Queries the Segment Tree for the maximum value in the given range
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Maximum value in the given range
     */
    @Override
    public int queryRange(int left, int right) {
        SegmentTreeNode node = queryRangeHelper(root,left,right);
        return node.getMax();
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
            return "" + node.getMax() + " ";
        String current = "" + node.getMax() + " ";
        String left = recursiveToString((SegmentTreeNode)node.getLeft());
        String right = recursiveToString((SegmentTreeNode)node.getRight());
        return current+left+right;
    }
}
