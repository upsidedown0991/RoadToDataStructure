package common;

public class ArrayUtils {
    public static void printArray(String tag, int[][] array){

        System.out.println(tag);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"   ");
            }
            System.out.println("");
        }

    }
}
