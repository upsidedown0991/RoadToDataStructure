package array;


import common.ArrayUtils;

/****
 * SparseArray
 * 稀疏数组就是数组中，大部分的元素值都未被使用（或都为0），在数组中仅有少 部分的空间使用,因此造成内存空间的浪费，
 * 为了解决这问题，并且不影响数组中原 有的元素值，我们采用了一种压缩的方式来 表示稀疏数组的内容。
 * 以下demo以二维数组为例子，表达数组与稀疏数组之间的相互转换。
 * 总结：
 * 稀疏数组是数组的一种压缩算法,可扩充至N维数组
 */
public class SparseArray {
    /****
     *
     *数组====================>稀疏数组=======>打印数组
     *
     * 稀疏数组================>数组==========>打印数组
     * @param args
     */
    public static void main(String[] args) {

        //1.定义一个二维数组，表达一个地图
        int[][] array = new int[8][7];
        array[3][4] = 1;
        array[5][5] = 6;
        array[7][6] = 2;

        ArrayUtils.printArray("print original array ======>", array);
        int[][] sparseArray = arrayToSparseArray(array);

        ArrayUtils.printArray("print arrayToSparseArray ======>", sparseArray);

        array = sparseArrayToArray(sparseArray);
        ArrayUtils.printArray("print sparseArrayToArray ======>", array);

    }

    /****
     * 二维array 压缩成 稀疏数组
     * @param array
     * @return
     */
    public static int[][] arrayToSparseArray(int[][] array) {
        //2.定义一个稀疏数组
        int numCount = 0;
        int arrayRow = array.length;
        int arrayColumn = array[0].length;


        //2.1获取 numCount
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    numCount++;
                }

            }
        }
        //2.2 创建稀疏数组
        int[][] sparseArray = new int[numCount + 1][3];

        //2.3 创建 稀疏数组的表头
        sparseArray[0][0] = arrayRow;
        sparseArray[0][1] = arrayColumn;
        sparseArray[0][2] = numCount;

        int index = 0;

        //2.4为稀疏数组赋值
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    index++;
                    for (int k = 0; k < numCount; k++) {
                        sparseArray[index][0] = i;
                        sparseArray[index][1] = j;
                        sparseArray[index][2] = array[i][j];
                    }
                }

            }
        }

        return sparseArray;
    }

    /****
     * 稀疏数组还原为二维array
     * @param sparseArray
     * @return
     */
    public static int[][] sparseArrayToArray(int[][] sparseArray) {
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];

        int[][] array = new int[row][column];

        for (int i = 1; i < sparseArray.length; i++) {

            int x = sparseArray[i][0];
            int y = sparseArray[i][1];
            int value = sparseArray[i][2];
            array[x][y] = value;
        }
        return array;
    }
}
