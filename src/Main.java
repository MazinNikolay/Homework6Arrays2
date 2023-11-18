import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrLength = 30;
        int[] arr = generateRandomArray(arrLength);
        int sumPayment = task1(arr);
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        task2(arr);
        task3(arr, sumPayment);
        task4(reverseFullName);
        task5HardWork();
        task6HardWork();
        task7HardWork();
        task8HardWork();
        task9HardWork();
    }

    public static int[] generateRandomArray(int length) {
        Random rnd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100_000, 200_000);
        }
        return arr;
    }

    public static int task1(int[] arr) {
        int sumPayment = 0;
        for (int i : arr) {
            sumPayment += i;
        }
        System.out.println("Сумма трат за месяц составила " + sumPayment + " рублей");
        return sumPayment;
    }

    public static void task2(int[] arr) {
        int paymentMin = arr[0];
        int paymentMax = arr[0];
        for (int i : arr) {
            if (i < paymentMin) {
                paymentMin = i;
            }
            if (i > paymentMax) {
                paymentMax = i;
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + paymentMin + " рублей. Максимальная сумма трат за день составила " + paymentMax + " рублей");
    }

    public static void task3(int[] arr, int sumPayment) {
        int monthCount = arr.length;
        float avgPayment = 0.0f;
        avgPayment = sumPayment / monthCount;
        System.out.println("Средняя сумма трат за месяц составила " + avgPayment + " рублей");
    }

    public static void task4(char[] reverseFullName) {
        for (int i = reverseFullName.length - 1; i >= 0; i--) {
            System.out.print(reverseFullName[i]);
        }
        System.out.println();
    }

    public static void task5HardWork() {
        Random rnd = new Random();
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j || j == (matrix[i].length - 1) - i) {
                    matrix[i][j] = 1;
                } else matrix[i][j] = rnd.nextInt(2, 15);
            }
        }
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void task6HardWork() {
        int[] arrOriginal = {5, 4, 3, 2, 1};
        int[] arrChanged = new int[5];
        int lengthVariable = arrChanged.length - 1;
        for (int i = 0; i < arrOriginal.length; i++) {
            arrChanged[lengthVariable - i] = arrOriginal[i];
        }
        System.out.println(Arrays.toString(arrOriginal));
        System.out.println(Arrays.toString(arrChanged));
    }

    public static void task7HardWork() {
        int tmpVariable;
        int[] arr = {5, 4, 3, 2, 1};
        int lengthVariable = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length / 2; i++) {
            tmpVariable = arr[i];
            arr[i] = arr[lengthVariable - i];
            arr[lengthVariable - i] = tmpVariable;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task8HardWork() {
        int[] arr = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int startPoint = 0;
        int endPoint = arr.length - 1;
        int arrValueStart = 0;
        int halfPoint = arr.length / 2;
        boolean notFound;
        while (arr[arrValueStart] + arr[halfPoint] != -2) {
            notFound = startPoint >= endPoint;
            if (arr[arrValueStart] + arr[halfPoint] > -2 && !notFound) {
                endPoint = halfPoint - 1;
            } else if (arr[arrValueStart] + arr[halfPoint] < -2 && !notFound) {
                startPoint = halfPoint + 1;
            } else if (notFound) {
                arrValueStart++;
                startPoint = arrValueStart + 1;
                endPoint = arr.length - 1;
            }
            halfPoint = (startPoint + endPoint) / 2;
        }
        System.out.println(arr[arrValueStart] + " " + arr[halfPoint]);
    }

    public static void task9HardWork() {
        int[] arr = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int startPoint = 0;
        int endPoint = arr.length - 1;
        int arrValueStart = 0;
        int halfPoint = arr.length / 2;
        boolean notFound;
        boolean found;
        while (arrValueStart < arr.length / 2) {
            notFound = startPoint >= endPoint;
            found = arr[arrValueStart] + arr[halfPoint] == -2;
            if (arr[arrValueStart] + arr[halfPoint] > -2 && !notFound) {
                endPoint = halfPoint - 1;
            } else if (arr[arrValueStart] + arr[halfPoint] < -2 && !notFound) {
                startPoint = halfPoint + 1;
            } else if (notFound || found) {
                if (found) System.out.println(arr[arrValueStart] + " " + arr[halfPoint]);
                arrValueStart++;
                startPoint = 0;
                endPoint = arr.length - 1;
            } else System.out.println("Элементы удовлетворяющие условию не найдены");
            halfPoint = (startPoint + endPoint) / 2;
        }
    }
}