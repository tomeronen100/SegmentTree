import java.util.Comparator;
import java.util.Iterator;

/**
 The NumberAnalyzer class provides an abstract implementation for analyzing a collection of integers.
 It implements the Iterable interface to allow for iteration over the collection, and the Comparator interface
 to provide a default comparison method for integers.
 */
public abstract class NumberAnalyzer implements Iterable<Integer>, Comparator<Integer> {

    protected Integer[] numbers;

    /**
     * Constructs a new NumberAnalyzer object with the given array of integers.
     * @param numbers The array of integers to be analyzed.
     */
    public NumberAnalyzer(Integer[] numbers) {
        this.numbers = numbers;
    }

    /**
     * implement of interface Iterator able move from index to the next one
     * @return the next index
     */
    public Iterator<Integer> iterator() {
        return new TreeIterator(numbers);
    }

    /**
     * class that able the Iterator
     */
     static class TreeIterator implements Iterator{
        private final Integer[] numbers;
        private int nextIndex;

        /**
         * Constructs the array and next pointer to be 0
         * @param numbers array of Integers
         */
        public TreeIterator(Integer[] numbers){
            this.numbers = numbers;
            this.nextIndex = 0;
        }


        /**
         * check if there is another index after the current
         * @return true or false - if there is next index
         */
        public boolean hasNext() {
            return nextIndex < numbers.length;
        }


        /**
         * give the value in the current index and move to the next one
         * @return the Integer in the current index
         */
        public Integer next() {
            if (!hasNext())
                return null;
            Integer ans = numbers[nextIndex];
            nextIndex += 1;
            return ans;
        }
    }

    /**
     * implementation of interface Comparator
     * the numbers compare by the following order: all even numbers by there value -> all odd numbers by there value
     * @param num1 the first Integer to be compared.
     * @param num2 the second Integer to be compared.
     * @return 1/-1/0 : 1 if the first bigger, -1 for the opposite, 0 if both are even
     */
    public int compare(Integer num1, Integer num2){
        if (num1 % 2 == 0 && num2 % 2 == 0)
            return compareTo(num1,num2);
        else if (num1 % 2 == 0)
            return 1;
        else if (num2 % 2 == 0)
            return -1;
        else
            return compareTo(num1,num2);
    }

    /**
     * check which number is bigger
     * @param num1 the first Integer to be compared.
     * @param num2 the second Integer to be compared.
     * @return 1/-1/0 : 1 if the first bigger, -1 for the opposite, 0 if both are even
     */
    public int compareTo(Integer num1, Integer num2){
        if (num1 > num2)
            return 1;
        else if (num2 > num1)
            return -1;
        else
            return 0;
    }

    /**
     * Returns the maximum value in the given range. This is an abstract function to be implemented by the subclasses
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The maximum value in the range.
     */
    public abstract Integer getMax(int left, int right);

    /**
     * Returns the minimum value in the given range. This is an abstract function to be implemented by the subclasses
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The minimum value in the range.
     */
    public abstract Integer getMin(int left, int right);

    /**
     * Returns the sum of the values in the given range. This is an abstract function to be implemented by the subclasses
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The sum of the values in the range.
     */
    public abstract Integer getSum(int left, int right);

    /**
     * Updates the value at the given index. This is an abstract function to be implemented by the subclasses
     * @param index The index of the value to be updated.
     * @param value The new value to be set at the given index.
     */
    public abstract void update(int index, int value);



}