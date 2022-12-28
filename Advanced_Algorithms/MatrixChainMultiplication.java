public class MatrixChainMultiplication {


    public static int getMinValue(int[] p, int[][] m, int[][] s, int i, int j) {
        int minValue = Integer.MAX_VALUE;
        int k = i;
        for (; k < j; k++) {
            int curValue = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
            if (curValue < minValue) {
                minValue = curValue;
                s[i][j] = k;
            }
        }
        return minValue;
    }

    public static void getMCM(int[] p, int[][] m, int[][] s, int n) {
        int d = 1;
        while (n > 0) {
            for (int i = 1; i < n; i++) {
                int j = i + d;
                m[i][j] = getMinValue(p, m, s, i, j);
            }
            d++;
            n--;
        }

    }

    public static void main(String[] args) {
        int[] p = {4, 10, 3, 12, 20, 7};
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        getMCM(p, m, s, n);
        n = p.length - 1;
        System.out.println("Array: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(p[i] + ", ");
        }
        System.out.println("\n\nMatrix of m: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix of s: ");
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= n; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }
}
