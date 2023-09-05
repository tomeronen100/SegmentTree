/**
 * implementation of Segment tree by array that build the tree by the Summation value
 * each node present the Summation of the numbers under it
 */
public class SummationSegmentTreeByArray extends SegmentTreeByArray {


    /**
     * Constructor for initializing the segment tree with the given input array.
     *
     * @param arr array of ints to build tree from
     */
    public SummationSegmentTreeByArray(int[] arr) {
        super(arr);
    }


    /**
     * Recursively builds the segment tree from the given array of integers.
     * for each node in the tree in index i : leftChild in index i*2, and rightChild in index i*2 + 1
     *
     * @param arr       the original array
     * @param nodeIndex the index on the tree array
     * @param nodeLeft  left side in the original array
     * @param nodeRight right side in the original array
     */
    public void recursiveBuildStba(int[] arr, int nodeIndex, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight)
            tree[nodeIndex] = arr[nodeLeft];
        else {
            int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
            int leftIndex = 2 * nodeIndex;
            int rightIndex = 2 * nodeIndex + 1;
            recursiveBuildStba(arr, leftIndex, nodeLeft, mid);
            recursiveBuildStba(arr, rightIndex, mid + 1, nodeRight);
            this.tree[nodeIndex] = this.tree[leftIndex] + this.tree[rightIndex];
        }
    }


    /**
     * Updates the value at the specified index and updates the segment tree recursively.
     *
     * @param treeIndex the index that suppose to change
     * @param nodeIndex the current index
     * @param nodeLeft  left side in the original array
     * @param nodeRight right side in the original array
     * @param value     the new value
     */
    public void recursiveUpgrade(int treeIndex, int nodeIndex, int nodeLeft, int nodeRight, int value) {
        if (nodeLeft == nodeRight)
            this.tree[nodeIndex] = value;
        else {
            int middle = nodeLeft + (nodeRight - nodeLeft) / 2;
            int leftIndex = 2 * nodeIndex;
            int rightIndex = 2 * nodeIndex + 1;
            if (treeIndex <= middle) {
                recursiveUpgrade(treeIndex, leftIndex, nodeLeft, middle, value);
            } else
                recursiveUpgrade(treeIndex, rightIndex, middle + 1, nodeRight, value);
            this.tree[nodeIndex] = this.tree[leftIndex] + this.tree[rightIndex];
        }
    }


    /**
     * Recursively return the sum for the query
     * @param node the current node
     * @param start the start index
     * @param end the end index
     * @param left the left index
     * @param right the right index
     * @return the result of the query operation
     */
    public int query(int node, int start, int end, int left, int right) {
        if (left <= right){
            if (left <= start && end <= right)
                return tree[node];
            else {
                int middle = start + (end - start) / 2;
                if (right <= middle)
                    return query(node * 2, start, middle, left, right);
                else if (left > middle)
                    return query(node * 2 + 1, middle + 1, end, left, right);
                int leftSide = query(node * 2, start, middle, left, middle);
                int rightSide = query(node * 2 + 1, middle + 1, end, middle + 1, right);
                return leftSide + rightSide;
            }
        }
        else return query(node, start, end, right, left);
    }

}
