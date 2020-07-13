import java.io.IOException;
import java.util.Arrays;

class TestSolution {

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 2, 3 }, { 0, 1 }, { 3, 4 } };
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println();
    }
}