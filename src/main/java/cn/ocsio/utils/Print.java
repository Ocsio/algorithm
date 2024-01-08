package cn.ocsio.utils;

public class Print {
    public static void print(int[][] arr) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < (arr[0].length << 2); i++) {
            line.append('>');
        }
        System.out.println(line);
        for (int[] ints : arr) {
            for (int a : ints) {
                System.out.printf("%-4d", a);
            }
            System.out.println();
        }
        System.out.println(line);
    }
}
