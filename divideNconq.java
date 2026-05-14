import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OS_Finding {
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] arr;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j <= right - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;

        return i;

    }


    static int randomPartition(int[] array, int left, int right) {
        //i will be the partition, picks a random num in array from range left, right
        Random ranPartition = new Random();//random variable
        int i = ranPartition.nextInt(right - left + 1) + left;//makes the random int the partion
        swap(array, i, right); //swap num chosen with the right node in array
        return partition(array, left, right); //That is now the partition
    }

    public static int randomSelect(int array[], int left, int right, int pivot) {
        if (left == right) {
            return array[left];// base case
        }
        int q = randomPartition(array, left, right);
        int k = q - left + 1;//puts pivot in middle using range of left to partition+1
        if (pivot == k) {
            return array[q];
        }
        if (pivot < k) {// if i us less than pivot
            return randomSelect(array, left, q - 1, pivot);//all num less than pviot
        } else {
            return randomSelect(array, q + 1, right, pivot-k);//all numbers greater
        }
    }
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <filename> <i>");
            return;
        }

        String filename = args[0];
        int k;
        try {
            k = Integer.parseInt(args[1]);
            if (k <= 0) {
                System.out.println("Error: i must be a natural number (>= 1).");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: i must be an integer.");
            return;
        }

        // Read numbers from the file
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    try {
                        list.add(Integer.parseInt(line));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }

        if (list.isEmpty()) {
            System.out.println("Error: File is empty or contains no valid integers.");
            return;
        }

        if (k > list.size()) {
            System.out.println("Error: i is larger than the number of elements in the file.");
            return;
        }

        // Convert ArrayList to array
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        // Find the k-th smallest element
        int result = randomSelect(array, 0, array.length - 1, k);
        System.out.println(k + "th smallest element is: " + result);
    }
}
