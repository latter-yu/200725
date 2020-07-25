public class Test {
    public static void main(String[] args) {
        int[] A = {15, 30, 61, 99};
        int n = 4;
        System.out.println(findMaxGap(A, n));
    }
    public static int findMaxGap(int[] A, int n) {
        // (左部分中的最大值减去右部分最大值) 的绝对值
        // 先找出最大值，再从两边找出较小的最大值
        int max = Integer.MIN_VALUE;
        int pos = 0; // 最大值的下标
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
                pos = i;
            }
        }
        int lm = Integer.MIN_VALUE; // leftMax
        int rm = Integer.MIN_VALUE; // rightMax
        for (int i = 0; i < pos; i++) {
            // 寻找左边的最大值
            if (A[i] > lm && max != A[0]) {
                lm = A[i];
            }
        }
        // 与最右边界值比较，若边界值较小，则差值更大
        if (A[0] < lm && max != A[0]) {
            lm = A[0];
        }
        for (int i = n - 1; i > pos; i--) {
            // 寻找右边的最大值
            if (A[i] > rm && max != A[n - 1]) {
                rm = A[i];
            }
        }
        // 与最右边界值比较，若边界值较小，则差值更大
        if (A[n - 1] < rm && max != A[n - 1]) {
            rm = A[n - 1];
        }
        if (pos == n - 1) {
            return Math.abs(max - lm);
        }
        if (pos == 0) {
            return Math.abs(max - rm);
        }
        if (Math.abs(max - rm) > Math.abs(max - lm)) {
            return Math.abs(max - rm);
        } else {
            return Math.abs(max - lm);
        }
    }
}

class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // 顺时针打印矩阵
        // 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。

        // 给定 int 矩阵 mat,以及它的维数 nxm
        // 请返回一个数组，数组中的元素为矩阵元素的顺时针输出。

        // 测试样例：
        // [[1, 2], [3, 4]], 2, 2
        // 返回：[1, 2, 4, 3]

        int[] arr = new int[n * m];
        int cur = 0;
        int startX = 0;
        int endX = m - 1;
        int startY = 0;
        int endY = n - 1;
        // 循环条件
        while (startX <= endX && startY <= endY) {
            if (startX <= endX) {
                for (int i = startX; i <= endX; i++) {
                    // 从左往右
                    arr[cur] = mat[startY][i];
                    cur++;
                }
            }
            if (startY < endY) {
                for (int j = startY + 1; j <= endY; j++) {
                    // 从上往下
                    arr[cur] = mat[j][endX];
                    cur++;
                }
            }
            if (startX < endX && endY > startY) {
                for (int i = endX - 1; i >= startX; i--) {
                    // 从右往左
                    arr[cur] = mat[endY][i];
                    cur++;
                }
            }
            if (startY < endY && endX > startX) {
                for (int j = endY - 1; j > startY; j--) {
                    // 从下往上
                    arr[cur] = mat[j][startX];
                    cur++;
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return arr;
    }
}