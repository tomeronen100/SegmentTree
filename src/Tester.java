/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

    private static boolean testPassed = true;
    private static int testNum = 0;

    /**
     * This entry function will test all classes created in this assignment.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        /* TODO - write a function for each class separately */
        // Each function here should test a different class. you should test here every class you created.


        //SegmentTrees
        testMaximumSegmentTreeByTree();
        testMinimumSegmentTreeByTree();
        testSummationSegmentTreeByTree();

        testMaximumSegmentTreeByArray();
        testMinimumSegmentTreeByArray();
        testSummationSegmentTreeByArray();

        //NumberAnalyzers
        testNumberAnalyzerByTrees();
        testNumberAnalyzerByArrays();

        // Notifying the user that the code have passed all tests.
        if (testPassed) {
            System.out.println("All " + testNum + " tests passed!");
        }
    }

    /**
     * This utility function will count the number of times it was invoked.
     * In addition, if a test fails the function will print the error message.
     *
     * @param exp The actual test condition
     * @param msg An error message, will be printed to the screen in case the test fails.
     */
    private static void test(boolean exp, String msg) {
        testNum++;

        if (!exp) {
            testPassed = false;
            System.out.println("Test " + testNum + " failed: " + msg);
        }
    }






    /**
     * Checks the MaximumSegmentTreeByTree class.
     */
    private static void testMaximumSegmentTreeByTree() {

        MaximumSegmentTreeByTree mstbt = new MaximumSegmentTreeByTree(new int[]{60, 10, 5, 15, 6});
        test(mstbt.size == 5, "the size should be 5");
        test(mstbt.queryRange(0, 3) == 60, "The max of {60,10,5,15,6} between indexes [0:3] should be 60");
        test(mstbt.toString().equals(" [ 60 60 60 60 10 5 15 15 6 ] "), "The toString of {60, 10, 5, 15, 6} should be ' [ 60 60 60 60 10 5 15 15 6 ] ' got: '" + mstbt.toString() + " '");
        mstbt.update(1, 80);
        test(mstbt.queryRange(3, 0) == 80, "After update index 1 from {60,10,5,15,6} to 80, the max between indexes [0:3] should be 80");
        test(mstbt.toString().equals(" [ 80 80 80 60 80 5 15 15 6 ] "), "The toString of {60,80,5,15} , after update index 3 to val 0, should be ' [ 80 80 80 60 80 5 15 15 6 ] ' got: '" + mstbt.toString() + " '");

        MaximumSegmentTreeByTree mstbt2 = new MaximumSegmentTreeByTree(new int[]{0});
        test(mstbt2.size == 1, "the size should be 1");
        test(mstbt2.queryRange(0, 0) == 0, "The max of {0} between indexes [0:0] should be 0");
        test(mstbt2.toString().equals(" [ 0 ] "), "The toString of {0} should be ' [ 0 ] ' got: '" + mstbt.toString() + " '");
        mstbt2.update(0, -1);
        test(mstbt2.queryRange(0, 0) == -1, "After update index 0 from {0} to -1, the max between indexes [0:0] should be -1");
        test(mstbt2.toString().equals(" [ -1 ] "), "The toString of {0} , after update index 0 to val -1, should be ' [ -1 ] ' got: '" + mstbt.toString() + " '");

    }

    /**
     * Checks the MinimumSegmentTreeByTree class.
     */
    private static void testMinimumSegmentTreeByTree(){
        MinimumSegmentTreeByTree mstbt = new MinimumSegmentTreeByTree(new int[]{1,3,2});
        test(mstbt.queryRange(0, 1) == 1, "The min of {1,3,2} between indexes [0:1] should be 1");
        test(mstbt.toString().equals(" [ 1 1 1 3 2 ] "), "The toString of {1,3,2} should be ' [ 1 1 1 3 2 ] ' got: '" + mstbt.toString() + " '");
        mstbt.update(2, -33);
        test(mstbt.queryRange(0, 2) == -33, "After update index 2 from {1,3,2} to -33, the min between indexes [0:2] should be -33");
        test(mstbt.toString().equals(" [ -33 1 1 3 -33 ] "), "The toString of {1,3,2} , after update index 2 to val -33, should be ' [ -33 1 1 3 -33 ] ' got: '" + mstbt.toString() + " '");

        MinimumSegmentTreeByTree mstbt2 = new MinimumSegmentTreeByTree(new int[]{0});
        test(mstbt2.size == 1, "the size should be 1");
        test(mstbt2.queryRange(0, 0) == 0, "The min of {0} between indexes [0:0] should be 0");
        test(mstbt2.toString().equals(" [ 0 ] "), "The toString of {0} should be ' [ 0 ] ' got: '" + mstbt2.toString() + " '");
        mstbt2.update(0, -1);
        test(mstbt2.queryRange(0, 0) == -1, "After update index 0 from {0} to -1, the max between indexes [0:0] should be -1");
        test(mstbt2.toString().equals(" [ -1 ] "), "The toString of {0} , after update index 0 to val -1, should be ' [ -1 ] ' got: '" + mstbt2.toString() + " '");

    }

    /**
     * Checks the SummationSegmentTreeByTree class.
     */
    private static void testSummationSegmentTreeByTree() {
        SummationSegmentTreeByTree sstbt = new SummationSegmentTreeByTree(new int[]{76,2,-74, 0, 123, -1, -1, 76, 0, 0, 40, -240});
        test(sstbt.queryRange(0, 11) == 1, "The sum of {76,2,-74, 0, 123, -1, -1, 76, 0, 0, 40, -240} between indexes [0:11] should be 1");
        test(sstbt.toString().equals(" [ 1 126 4 78 76 2 -74 122 123 0 123 -1 -125 75 75 -1 76 0 -200 40 0 40 -240 ] "), "The toString of {76,2,-74, 0, 123, -1, -1, 76, 0, 0, 40, -240} should be ' [ 1 126 4 78 76 2 -74 122 123 0 123 -1 -125 75 75 -1 76 0 -200 40 0 40 -240 ] ' got: '" + sstbt.toString() + " '");

        sstbt.update(5,-10);
        test(sstbt.queryRange(4, 8) == 188, "After update index 2 from {76,2,-74, 0, 123, -1, -1, 76, 0, 0, 40, -240} to -10, the sum between indexes [4:8] should be 188");
        test(sstbt.toString().equals(" [ -8 117 4 78 76 2 -74 113 123 0 123 -10 -125 75 75 -1 76 0 -200 40 0 40 -240 ] "), "The toString of {76,2,-74, 0, 123, -1, -1, 76, 0, 0, 40, -240} , after update index 5 to val -10, should be ' [ -8 117 4 78 76 2 -74 113 123 0 123 -10 -125 75 75 -1 76 0 -200 40 0 40 -240 ] ' got: '" + sstbt.toString() + " '");
    }







    /**
     * Checks the MaximumSegmentTreeByArray class.
     */
    private static void testMaximumSegmentTreeByArray() {

        MaximumSegmentTreeByArray mstba = new MaximumSegmentTreeByArray(new int[]{10,15,55,15,9,12});
        test(mstba.size == 6, "the size of {10,15,55,15,9,12} is 6");
        test(mstba.toString().equals(" [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] "),"The toString of {10,15,55,15,9,12} should be ' [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] ' got: '" + mstba.toString()+ " '");
        test(mstba.queryRange(0,1) == 15, "The max of {10,15,55,15,9,12} between indexes [0:1] should be 15");
        mstba.update(0,80);
        test(mstba.queryRange(0,0) == 80, "After update index 0 from {10,15,55,15,9,12} to 80, the max between indexes [0:0] should be 80");
        test(mstba.toString().equals(" [ 80 80 15 80 55 15 12 80 15 - - 15 9 - - ] "),"The toString of {10,15,55,15,9,12}, after update index 0 from to val 80, should be ' [ 80 80 15 80 55 15 12 80 15 - - 15 9 - - ] ' got: '" + mstba.toString()+ " '");

        MaximumSegmentTreeByArray mstbt2 = new MaximumSegmentTreeByArray(new int[]{0});
        test(mstbt2.size == 1, "the size should be 1");
        test(mstbt2.queryRange(0, 0) == 0, "The max of {0} between indexes [0:0] should be 0");
        test(mstbt2.toString().equals(" [ 0 ] "), "The toString of {0} should be ' [ 0 ] ' got: '" + mstbt2.toString() + " '");
        mstbt2.update(0, -1);
        test(mstbt2.queryRange(0, 0) == -1, "After update index 0 from {0} to -1, the max between indexes [0:0] should be -1");
        test(mstbt2.toString().equals(" [ -1 ] "), "The toString of {0} , after update index 0 to val -1, should be ' [ -1 ] ' got: '" + mstbt2.toString() + " '");

    }

    /**
     * Checks the MinimumSegmentTreeByArray class.
     */
    private static void testMinimumSegmentTreeByArray(){

        MinimumSegmentTreeByArray mstba = new MinimumSegmentTreeByArray(new int[]{1,3,2});
        test(mstba.toString().equals(" [ 1 1 2 1 3 - - ] "), "The toString of {1,3,2} should be ' [ 1 1 2 1 3 - - ] ' got: '" + mstba.toString() + " '");
        test(mstba.queryRange(0, 2) == 1, "The min of {1,3,2} between indexes [0:2] should be 1");
        mstba.update(0, 3);
        test(mstba.queryRange(1, 0) == 3, "After update index 0 from {1,3,2} to 3, the min between indexes [0:1] should be 3");
        test(mstba.toString().equals(" [ 2 3 2 3 3 - - ] "), "The toString of {1,3,2} after update index 0 to val 3, should be ' [ 2 3 2 3 3 - - ] ' got: '" + mstba.toString() + " '");
    }

    private static void testSummationSegmentTreeByArray(){
        SummationSegmentTreeByArray mstba = new SummationSegmentTreeByArray(new int[]{-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2});
        test(mstba.queryRange(0, 20) == 0, "The sum of {-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2} between indexes [3:3] should be 0");
        test(mstba.toString().equals(" [ 0 -2 2 -2 0 0 2 -2 0 0 0 0 0 0 2 -2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 -2 0 - - 0 0 - - 0 0 - - - - - - 0 0 - - - - - - 0 0 - - - - - - ] "), "The toString of {-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2} should be ' [ 2 0 2 0 0 0 2 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 -2 0 - - 0 0 - - 0 0 - - - - - - 0 0 - - - - - - 0 0 - - - - - - ] ' got: '" + mstba.toString() + " '");

        mstba.update(20, 0);
        test(mstba.queryRange(0, 20) == -2, "After update index 20 from {-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2} to 0, the min between indexes [0:20] should be -2");
        test(mstba.toString().equals(" [ -2 -2 0 -2 0 0 0 -2 0 0 0 0 0 0 0 -2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -2 0 - - 0 0 - - 0 0 - - - - - - 0 0 - - - - - - 0 0 - - - - - - ] "), "The toString of {-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2} should be ' [ -2 -2 0 -2 0 0 0 -2 0 0 0 0 0 0 0 -2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -2 0 - - 0 0 - - 0 0 - - - - - - 0 0 - - - - - - 0 0 - - - - - - ] ' got: '" + mstba.toString() + " '");

        SummationSegmentTreeByArray mstbt2 = new SummationSegmentTreeByArray(new int[]{0});
        test(mstbt2.size == 1, "the size should be 1");
        test(mstbt2.queryRange(0, 0) == 0, "The sum of {0} between indexes [0:0] should be 0");
        test(mstbt2.toString().equals(" [ 0 ] "), "The toString of {0} should be ' [ 0 ] ' got: '" + mstbt2.toString() + " '");
        mstbt2.update(0, -1);
        test(mstbt2.queryRange(0, 0) == -1, "After update index 0 from {0} to -1, the max between indexes [0:0] should be -1");
        test(mstbt2.toString().equals(" [ -1 ] "), "The toString of {0} , after update index 0 to val -1, should be ' [ -1 ] ' got: '" + mstbt2.toString() + " '");

    }










    /**
     * Checks the NumberAnalyzerByTrees class.
     */
    private static void testNumberAnalyzerByTrees() {

        Integer[] arr = {10, 30, 50};
        NumberAnalyzerByTrees nabt = new NumberAnalyzerByTrees(arr);

        test(nabt.getMax(0, 1) == 30, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabt.getMin(0, 1) == 10, "The min of {10,30,50} between indexes [0:1] should be 10");
        test(nabt.getSum(0, 1) == 40, "The sum of {10,30,50} between indexes [0:1] should be 40");
        test(nabt.compare(nabt.getSum(0, 1), nabt.getMax(2, 2)) == -1, "the greater number should be 50 and return -1");

        test(nabt.compare(arr[0],arr[0]+1) == 1, "10 is bigger then 11 by our Comperator so it should return 1");

    }

    private static void testNumberAnalyzerByArrays() {

        Integer[] arr = {0,20,-20,-20,20,0};
        NumberAnalyzerByArrays naba = new NumberAnalyzerByArrays(arr);

        test(naba.getMax(2,4) == 20, "The max of {0,20,40,-20,-40,0} between indexes [2:4] should be 40");
        test(naba.getMin(0,1) == 0, "The min of {0,20,40,-20,-40,0} between indexes [0:1] should be 0");
        test(naba.getSum(0,5) == 0, "The sum of {0,20,40,-20,-40,0} between indexes [0:5] should be 0");
        test(naba.compare(naba.getSum(0,2),naba.getSum(3,5)) == 0, "the numbers should be equal and return 0");
        test(naba.compare(arr[0]-1,arr[0]-2) == -1, "-2 is bigger then -1 by our Comperator so it should return -1");

    }

}
