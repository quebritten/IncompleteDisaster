public class Tester {
    public static void main(String[] args) {
        Main.LinkedList<Integer> listA = new Main.LinkedList<>();
       Main.LinkedList<Integer> listB = new Main.LinkedList<>();
        int listSize= 2000;



        // Fill lists with test data
        // Populate both lists with the same numbers
        for (int i = 0; i <listSize; i++) {
            listA.addLast(listSize);
            listB.addLast(listSize);
        }

        // Run MergeSort without timing

        double then = System.currentTimeMillis();
        listA.MergeSort();
        double now = System.currentTimeMillis();
        System.out.println(now - then);
        System.out.println("MergeSort sorted correctly? " + listA.isSorted());
        System.out.println("Size of list A: " + listA.getSize());

        // Run InsertionSort without timing
        then = System.currentTimeMillis();
        listB.MergeSort();
        now = System.currentTimeMillis();
        listB.InsertionSort();
        System.out.println(now - then);
        System.out.println("InsertionSort sorted correctly? " + listB.isSorted());
        System.out.println("Size of list list B: " + listB.getSize());
    }
}

