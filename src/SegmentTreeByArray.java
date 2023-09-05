/**
 * This abstract class represents a segment tree implementation using an array
 * and provides methods to build, update, and query the tree.
 */
public abstract class SegmentTreeByArray implements SegmentTree {
     
	 protected int[] tree;
	 protected int size;

    /**
     * Constructor for initializing the segment tree with the given input array.
     * @param arr the input array
     */
    public SegmentTreeByArray(int[] arr) {
        build(arr);
    }

    /**
     * Builds the segment tree from the input array.
     * @param arr the input array
     */
    @Override

    public void build(int[] arr) {
        int x = 1;
        if (arr.length > 0) { // ואם הוא שווה ל0??
            while (x < arr.length)
                x *= 2;
        }
        int treeSize = 2 * x;
        this.tree = new int[treeSize];
        for (int i=0; i<treeSize;i++)
            this.tree[i] = Integer.MAX_VALUE;
        this.size = arr.length;
        recursiveBuildStba(arr, 1, 0, arr.length - 1);
    }

    /**
     * Recursively builds the segment tree from the given array of integers.
     * for each node in the tree in index i : leftChild in index i*2, and rightChild in index i*2 + 1
     * @param arr the original array
     * @param nodeIndex the index on the tree array
     * @param nodeLeft left side in the original array
     * @param nodeRight right side in the original array
     */
     public abstract void recursiveBuildStba(int[] arr, int nodeIndex, int nodeLeft, int nodeRight);



    /**
     * Updates the value at the specified index and updates the segment tree accordingly.
     * @param index the index of the element to update in the array
     * @param value the new value to replace the existing value
     */
    @Override
    public void update(int index, int value) {
        //IMPLEMENT THE FUNCTION
        // You might want to add a helping functions for this.
        recursiveUpgrade(index, 1, 0, size - 1, value);
    }


    /**
     * Updates the value at the specified index and updates the segment tree recursively.
     * @param treeIndex the index that suppose to change
     * @param nodeIndex the current index
     * @param nodeLeft left side in the original array
     * @param nodeRight right side in the original array
     * @param value the new value
     */
    public abstract void recursiveUpgrade(int treeIndex, int nodeIndex, int nodeLeft, int nodeRight, int value);

    /**
     * Queries the segment tree for a range of elements.
     * @param left the left index of the range
     * @param right the right index of the range
     * @return the result of the query operation
     */
    @Override
    public int queryRange(int left, int right) {
       //IMPLEMENT THE FUNCTION
	   // use the query function for the implementation.
        return query(1, 1, size, left+1, right+1);
    }




    /**
     * Abstract method for query operation, to be implemented by subclasses.
     * @param node the current node
     * @param start the start index
     * @param end the end index
     * @param left the left index
     * @param right the right index
     * @return the result of the query operation
     */
    protected abstract int query(int node, int start, int end, int left, int right);




    /**
     * The members inside the array representing the segment tree are printed according to their indexes in the array.
	 * When the members are surrounded by "[ ]" and exactly one space between each number and between the brackets. 
	 * For example, for the tree [10,4,6,1,3,2,4] " [ 10 4 6 1 3 2 4 ] " will be returned 
     */
    @Override
    public String toString() {
        String sb = " [ ";
        for (int i = 1; i < tree.length; i++) {
            int val = tree[i];
            if (val==Integer.MAX_VALUE)
                sb += "- ";
            else
                sb += tree[i] + " ";
        }
        sb+= "] ";
        return sb;
    }




    /**
     * Returns the number of elements in the original array that the segment tree was built from.
     *
     * @return the size of the original array
     */
    @Override
    public int size() {
        return size;
    }
}