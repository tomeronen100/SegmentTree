/**
 * Implement the NumberAnalyzer class by using SegmentTreeByTree class.
 * The use is to analyze a collection of integers.
 */
public class NumberAnalyzerByArrays extends NumberAnalyzer {

    private final SegmentTreeByArray minByArray;
    private final SegmentTreeByArray maxByArray;
    private final SegmentTreeByArray sumByArray;

    /**
     * Constructs a new NumberAnalyzerByArrays object with the given array of integers.
     * @param numbers The array of integers to be analyzed.
     */
    public NumberAnalyzerByArrays(Integer[] numbers) {
        super(numbers);
        this.maxByArray = new MaximumSegmentTreeByArray(convertArray(numbers));
        this.minByArray = new MinimumSegmentTreeByArray(convertArray(numbers));
        this.sumByArray = new SummationSegmentTreeByArray(convertArray(numbers));
    }


    /**
     * convert array of Integers to array of primitives ints
     * @param numbers array to Integers
     * @return array to primitives ints
     */
    public int[] convertArray(Integer[] numbers) {
        int[] newArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newArr[i] = (int) numbers[i];
        }
        return newArr;
    }


    /**
     * Returns the maximum value in the given range
     *
     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The maximum value in the range.
     */
    public Integer getMax(int left, int right) {
        return maxByArray.queryRange(right, left);

    }

    /**
     * Returns the minimum value in the given range
     *
     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The minimum value in the range.
     */
    public Integer getMin(int left, int right) {
        return minByArray.queryRange(right, left);
    }

    /**
     * Returns the sum of the values in the given range
     *
     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The sum of the values in the range.
     */
    public Integer getSum(int left, int right) {
        return sumByArray.queryRange(right, left);
    }

    /**
     * Updates the value at the given index
     *
     * @param index The index of the value to be updated.
     * @param value The new value to be set at the given index.
     */
    public void update(int index, int value) {
        numbers[index] = value;
        maxByArray.update(index, value);
        minByArray.update(index, value);
        sumByArray.update(index, value);
    }
}
