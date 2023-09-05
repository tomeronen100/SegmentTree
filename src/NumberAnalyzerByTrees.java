/**
 * Implement the NumberAnalyzer class by using SegmentTreeByTree class.
 * The use is to analyze a collection of integers.
 */
public class NumberAnalyzerByTrees extends NumberAnalyzer {

    private final SegmentTreeByTree minByTree;
    private final SegmentTreeByTree maxByTree;
    private final SegmentTreeByTree sumByTree;

    /**
     * Constructs a new NumberAnalyzerByTrees object with the given array of integers.
     * @param numbers The array of integers to be analyzed.
     */
    public NumberAnalyzerByTrees(Integer[] numbers) {
        super(numbers);
        this.maxByTree = new MaximumSegmentTreeByTree(convertArray(numbers));
        this.minByTree = new MinimumSegmentTreeByTree(convertArray(numbers));
        this.sumByTree = new SummationSegmentTreeByTree(convertArray(numbers));
    }


    /**
     * convert array of Integers to array of primitives ints
     * @param numbers array to Integers
     * @return array to primitives ints
     */
    public int[] convertArray(Integer[] numbers) {
        int[] newArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newArr[i] = (int)numbers[i];
        }
        return newArr;
    }


    /**
     * Returns the maximum value in the given range
     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The maximum value in the range.
     */
    public Integer getMax(int left, int right) {
        return maxByTree.queryRange(left, right);
    }

    /**
     * Returns the minimum value in the given range
     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The minimum value in the range.
     */
    public Integer getMin(int left, int right) {
        return minByTree.queryRange(left, right);
    }

    /**
     * Returns the sum of the values in the given range
     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The sum of the values in the range.
     */
    public Integer getSum(int left, int right) {
        return sumByTree.queryRange(left, right);
    }

    /**
     * Updates the value at the given index
     * @param index The index of the value to be updated.
     * @param value The new value to be set at the given index.
     */
    public void update(int index, int value) {
        numbers[index] = value;
        maxByTree.update(index, value);
        minByTree.update(index, value);
        sumByTree.update(index, value);
    }
}
