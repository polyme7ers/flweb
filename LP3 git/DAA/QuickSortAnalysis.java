import java.util.*;

public class QuickSortAnalysis {

    static int stepDet = 0, stepRand = 0;

    // ---------- DETERMINISTIC QUICK SORT ----------
    static void quickSortDeterministic(int arr[], int low, int high) {
        if (low < high) {
            stepDet++; // counting recursive call
            int pi = partitionDet(arr, low, high);
            quickSortDeterministic(arr, low, pi - 1);
            quickSortDeterministic(arr, pi + 1, high);
        }
    }

    static int partitionDet(int arr[], int low, int high) {
        int pivot = arr[high]; // fixed pivot (last element)
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            stepDet++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ---------- RANDOMIZED QUICK SORT ----------
    static void quickSortRandomized(int arr[], int low, int high) {
        if (low < high) {
            stepRand++;
            int pi = randomizedPartition(arr, low, high);
            quickSortRandomized(arr, low, pi - 1);
            quickSortRandomized(arr, pi + 1, high);
        }
    }

    static int randomizedPartition(int arr[], int low, int high) {
        Random rand = new Random();
        int randomPivot = low + rand.nextInt(high - low + 1);

        // swap random pivot with last element
        int temp = arr[randomPivot];
        arr[randomPivot] = arr[high];
        arr[high] = temp;

        return partitionRand(arr, low, high);
    }

    static int partitionRand(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            stepRand++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ---------- MAIN FUNCTION ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int arr2[] = arr1.clone();

        quickSortDeterministic(arr1, 0, n - 1);
        quickSortRandomized(arr2, 0, n - 1);

        System.out.println("\nSorted array using Deterministic QuickSort:");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Step count (Deterministic): " + stepDet);

        System.out.println("\nSorted array using Randomized QuickSort:");
        System.out.println(Arrays.toString(arr2));
        System.out.println("Step count (Randomized): " + stepRand);

        sc.close();
    }
}
