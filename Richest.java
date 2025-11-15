import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Richest {
    private static final int K = 10000;// top values

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Richest <input-file>");
            System.exit(1);//error msg
        }

        String inputFile = args[0];//input file name
        String outputFile = "richest.output";//output file name
        long[] heap = new long[10001];//10001 to skip 0
        int heapSize = 0;//starts with nothing in heap

        try (BufferedReader buffRead = new BufferedReader(new FileReader(inputFile))) {
            String var6;//string read from file
            while(heapSize < 10000 && (var6 = buffRead.readLine()) != null) {
                var6 = var6.trim();
                if (!var6.isEmpty()) {
                    try {
                        long val = Long.parseLong(var6);
                        ++heapSize;
                        heap[heapSize] = val;
                    } catch (NumberFormatException var13) {
                        System.err.println("Warning: skipping non-integer line: " + var6);
                    }
                }
            }//reads off 10,000 at a time

            if (heapSize > 0) {
                buildMinHeap(heap, heapSize);
            }//heap for min values

            while((var6 = buffRead.readLine()) != null) {
                var6 = var6.trim();
                if (!var6.isEmpty()) {
                    long newVal;
                    try {
                        newVal = Long.parseLong(var6);
                    } catch (NumberFormatException var16) {
                        System.err.println("Warning: skipping non-integer line: " + var6);
                        continue;
                    }

                    if (heapSize < 10000) {
                        ++heapSize;
                        heap[heapSize] = newVal;
                        heapifyUp(heap, heapSize);
                    } else if (newVal > heap[1]) {
                        heap[1] = newVal;
                        minHeapify(heap, 1, heapSize);
                    }
                }
            }//process remaining num
        } catch (FileNotFoundException var18) {
            System.err.println("Input file not found: " + inputFile);
            System.exit(2);
        } catch (IOException var19) {
            System.err.println("I/O error reading file: " + var19.getMessage());
            System.exit(3);
        }

        if (heapSize == 0) {
            try {
                BufferedWriter var21 = new BufferedWriter(new FileWriter(outputFile));
                var21.close();
            } catch (IOException var10) {
                System.err.println("I/O error writing output file: " + var10.getMessage());
                System.exit(4);
            }//if given empty file

            System.out.println("No numbers found in input. Created empty " + outputFile);
        } else {
            heapSortDescending(heap, heapSize);

            try (BufferedWriter var20 = new BufferedWriter(new FileWriter(outputFile))) {
                for(int var25 = 1; var25 <= heapSize; ++var25) {
                    var20.write(Long.toString(heap[var25]));
                    var20.newLine();
                }//each num gets a line
            } catch (IOException var15) {
                System.err.println("I/O error writing output file: " + var15.getMessage());
                System.exit(5);
            }

            System.out.println("Wrote top " + heapSize + " numbers to " + outputFile);
        }
    }

    private static void buildMinHeap(long[] heap, int heapSize) {
        for(int i = heapSize / 2; i >= 1; i--) {
            minHeapify(heap, i, heapSize);
        }

    }

    private static void minHeapify(long[] heap, int pos, int heapSize) {
        while(true) {
            int leftChild = 2 * pos;
            int rightChild = leftChild + 1;
            int smallest = pos;

            if (leftChild <= heapSize && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild <= heapSize && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if (smallest == pos) {
                return;
            }

            swap(heap, pos, smallest);
            pos = smallest;
        }
    }

    private static void heapifyUp(long[] heap, int pos) {
        while(true) {
            if (pos > 1) {
                int parent = pos / 2;
                if (heap[parent] > heap[pos]) {
                    swap(heap, parent ,pos);
                    pos = parent;
                }
            }

            return;
        }
    }

    private static void heapSortDescending(long[] heap, int heapSize) {
        for(int i = heapSize; i >= 2; i--) {
            swap(heap, 1, i);
            minHeapify(heap,1,i-1);
        }

    }

    private static void swap(long[] heap, int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
