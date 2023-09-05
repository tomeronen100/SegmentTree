public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr1 = {1,3,5,7,9,11};
        int[] arr2 = {60,10,5,15,6};
        int[] arr3 = {60,80,5,15};
        int[] arr4 = {76,2,-74, 0, 123, -1, -1, 76, 0, 0, 40, -240};
        int[] arr5 = {0,4,17,-4,17};
        SummationSegmentTreeByTree mstbt = new SummationSegmentTreeByTree(arr5);
        //mstbt.queryRangeHelper(mstbt.root, 0,7);
        //System.out.println(mstbt.queryRangeHelper(mstbt.root, 1,5));
        //mstbt.update(5,-10);
        //treePrint(mstbt.queryRangeHelper(mstbt.root, 0,9));
        //System.out.println(mstbt.queryRange(4,8));
        treePrint(mstbt.root);


//        int[] arrByArr1 = {1,3,2,4};
//        int[] arrByArr2 = {1,3,2};
//        int[] arrByArr3 = {10,15,55,15,9,12};
//        int[] arrByArr4 = {60,10,5,15,5};
//        int[] arrByArr5 = {-2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
//        MaximumSegmentTreeByArray mstba = new MaximumSegmentTreeByArray(arrByArr3);
//        System.out.println(" 1 + " + mstba);
//        mstba.update(0,80);
//        System.out.println(" 2 + " + mstba);
//        System.out.println(mstba.size);
//        //System.out.println(mstba.queryRange(0,4));
//        //System.out.println(mstba.queryRange(0,2));

    }
    public static void treePrint(TreeNode node) {
        System.out.println(node);
        if (node.leftChild != null) {
            treePrint(node.leftChild);
        }
        if (node.rightChild != null) {
            treePrint(node.rightChild);
        }
    }
}