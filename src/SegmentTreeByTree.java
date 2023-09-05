/**
 * An abstract base class for a segment tree data structure implemented using a tree structure.
 * Subclasses must implement the {@code queryRange} method to provide specific range query functionality.
 */
public abstract class SegmentTreeByTree implements SegmentTree {

    protected SegmentTreeNode root;
    protected int size;

    /**
     * Constructor for creating a Segment Tree from an input array
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public SegmentTreeByTree(int[] arr) {
        build(arr);
    }

    /**
     * Builds the segment tree from the given array of integers.
     *
     * @param arr the array of integers to build the segment tree from
     */
    @Override
    public void build(int[] arr) {
        this.size = arr.length;
        this.root = recusvieBuildStbt(0, arr.length -1, arr);
    }

    public SegmentTreeNode recusvieBuildStbt(int left, int right, int[] arr){
        if (left == right){
            return new SegmentTreeNode(left,right,arr[0],arr[0],arr[0],null,null);}
        else{
            int middle = (left + right)/2;
            SegmentTreeNode leftChild =  recusvieBuildStbt(left,middle,leftHalf(arr));
            SegmentTreeNode rightChild =  recusvieBuildStbt(middle+1,right,rightHalf(arr));
            return new SegmentTreeNode(left, right, findMinInArray(arr), findMaxInArray(arr), findSumInArray(arr),
                    leftChild,rightChild);
        }
    }

    /**
     * find the minimum value in given array - for initialize it while build node
     * @param arr the node
     * @return int - the minimum value in that node
     */
    public int findMinInArray(int [] arr){
        int min = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * find the maximum value in given array - for initialize it while build node
     * @param arr the node
     * @return int - the maximum value in that node
     */
    public int findMaxInArray(int [] arr){
        int max = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * sum all the values in given array - to initialize it while build node
     * @param arr the node
     * @return int - sum of all the values in the node
     */
    public int findSumInArray(int[] arr){
        int res = 0;
        for (int i=0; i<arr.length; i++){
            res += arr[i];
        }
        return res;
    }

    /**
     * cut the array to two parts for dividing the nodes build
     * @param arr the node range
     * @return array - left part of given array
     */
    public int[] leftHalf(int[] arr){
        int[] slicedArr1 = new int [(arr.length+1)/2];
        for (int i = 0; i<slicedArr1.length; i++){
            slicedArr1[i] = arr[i];}
        return slicedArr1;
    }

    /**
     * cut the array to two parts for dividing the nodes build
     * @param arr the node range
     * @return array - left part of given array
     */
    public int[] rightHalf(int[] arr){
        int[] slicedArr2 = new int [arr.length - ((arr.length+1)/2)];
        for (int i = ((arr.length+1)/2); i<arr.length; i++){
            slicedArr2[i-((arr.length+1)/2)] = arr[i];}
        return slicedArr2;
    }






    /**
     * Updates the element at the specified index in the original array and updates the segment tree accordingly.
     *
     * @param index the index of the element to update
     * @param value the new value of the element at the specified index
     */
    @Override
    public void update(int index, int value) {
        recursiveUpgrade(root,index,value);
    }

    /**
     * updating in recursive the value and all the relevant nodes
     * @param node of the segment tree
     * @param index int - the index to change
     * @param value int - new value
     * @return null
     */
    public void recursiveUpgrade(SegmentTreeNode node, int index, int value) {
        if (node.getStart() == index && node.getEnd() == index) {
            node.setMin(value);
            node.setMax(value);
            node.setSum(value);
            return ;
        }
        int middle = (node.getStart() + node.getEnd()) /2;
        if (index <= middle)
            recursiveUpgrade((SegmentTreeNode)node.getLeft(),index,value);
        else
            recursiveUpgrade((SegmentTreeNode)node.getRight(),index,value);
        SegmentTreeNode leftChild = (SegmentTreeNode) node.getLeft();
        SegmentTreeNode rightChild = (SegmentTreeNode) node.getRight();
        node.setMin(findMinInMins(leftChild.getMin(), rightChild.getMin()));
        node.setMax(findMaxInMaxs(leftChild.getMax(), rightChild.getMax()));
        node.setSum(leftChild.getSum() + rightChild.getSum());
        return ;
    }



    /**
     * Returns the number of elements in the original array that the segment tree was built from.
     *
     * @return the size of the original array
     */
    @Override
    public int size() {
        return this.size;
    }




    /**
     * Queries the Segment Tree for the minimum value in the given range
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Min/max/sum value in the given range
     */
    @Override
    public abstract int queryRange(int left, int right);

    /**
     * Helper method for querying the Segment Tree 
     * @param node Current node of the Segment Tree
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return A SegmentTreeNode that contains the minimum, maximum and sum values for the given range
     */
    protected SegmentTreeNode queryRangeHelper(SegmentTreeNode node, int left, int right) {
        if (left <= right){
            int middle = (node.getStart() + node.getEnd())/2;
            if (left <= node.getStart() && node.getEnd() <= right)
                return node;
            else if (right <= middle)
                return queryRangeHelper((SegmentTreeNode)node.getLeft(),left,right);
            else if (left > middle)
                return queryRangeHelper((SegmentTreeNode)node.getRight(),left,right);
            else {
                SegmentTreeNode leftSide = queryRangeHelper((SegmentTreeNode) node.getLeft(), left, middle);
                SegmentTreeNode rightSide = queryRangeHelper((SegmentTreeNode) node.getRight(), middle + 1, right);
                int min = findMinInMins(leftSide.getMin(), rightSide.getMin());
                int max = findMaxInMaxs(leftSide.getMax(), rightSide.getMax());
                int sum = leftSide.getSum() + rightSide.getSum();
                return new SegmentTreeNode(left, right, min, max, sum, null, null);
            }
        }
        else return queryRangeHelper(node, right,left);
    }

    /**
     * find min val between two values
     * @param min1 first potential min
     * @param min2 second potential min
     * @return int - the minimum val
     */
    public int findMinInMins(int min1, int min2){
        if(min1 < min2)
            return min1;
        else
            return min2;
    }

    /**
     * find max val between two values
     * @param max1 first potential max
     * @param max2 second potential max
     * @return int - the maximum val
     */
    public int findMaxInMaxs(int max1, int max2) {
        if (max1 > max2)
            return max1;
        else
            return max2;
    }
}
