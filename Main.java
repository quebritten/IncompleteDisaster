public class Main {
    public static class LinkedList<T extends Comparable<T>> {

        private class Node {
            T data;
            Node next;
            Node(T data) { this.data = data; }
        }

        private Node head;
        private Node tail;
        private int size;
        
        public LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }


        // Adds an element to the front of the list
        public void addFirst(T data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            size++;
        }

        // Adds an element to the end of the list
        public void addLast(T data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }


        public T getFirst() {
            return (head != null) ? head.data : null;
        }

        public void removeFirst() {
            if (head != null) {
                head = head.next;
                if (head == null) tail = null; // list became empty
                size--;
            }
        }


        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        // Clears the list
        public void clear() {
            head = tail = null;
            size = 0;
        }

        public LinkedList<T> merge(LinkedList<T> A, LinkedList<T> B) {// not on test
            LinkedList<T> S = new LinkedList<>();

            // Merge elements while both lists are not empty
            while (!A.isEmpty() && !B.isEmpty()) {
                T fa = A.getFirst();
                T fb = B.getFirst();
                if (fa.compareTo(fb) < 0) {
                    S.addLast(fa);
                    A.removeFirst();
                } else {
                    S.addLast(fb);
                    B.removeFirst();
                }
            }


            while (!A.isEmpty()) {
                S.addLast(A.getFirst());
                A.removeFirst();
            }


            while (!B.isEmpty()) {
                S.addLast(B.getFirst());
                B.removeFirst();
            }

            return S;
        }

        public void MergeSort() {// not on test
            if (size <= 1) return; // already sorted

            Queue<LinkedList<T>> q = new Queue<>();

            //enqueue each element as its own LinkedList
            Node current = head;
            while (current != null) {
                LinkedList<T> newList = new LinkedList<>();
                newList.addFirst(current.data);
                q.enqueue(newList);
                current = current.next;
            }

            //merge pairs until only one list remains
            while (q.getSize() > 1) {
                LinkedList<T> sublist1 = q.dequeue();
                LinkedList<T> sublist2 = q.dequeue();
                LinkedList<T> merged = merge(sublist1, sublist2);
                q.enqueue(merged);
            }

            //replace this list's data with sorted list
            LinkedList<T> sortedList = q.dequeue();
            this.head = sortedList.head;
            this.tail = sortedList.tail;
            this.size = sortedList.size;
        }


        public void InsertionSort() {
            if (head == null || head.next == null) return; // already sorted

            Node sorted = null;  // start of sorted list
            Node current = head; // current node from original list

            while (current != null) {
                Node next = current.next; // store next node

                // Insert at front if sorted is empty or current < first
                if (sorted == null || sorted.data.compareTo(current.data) >= 0) {
                    current.next = sorted;
                    sorted = current;
                } else {
                    // Find position in sorted list
                    Node temp = sorted;
                    while (temp.next != null && temp.next.data.compareTo(current.data) < 0) {
                        temp = temp.next;
                    }
                    current.next = temp.next;
                    temp.next = current;
                }

                current = next;
            }
            head = sorted;
            tail = head;
            while (tail != null && tail.next != null) {
                tail = tail.next;
            }
        }

        public boolean isSorted() {
            if (head == null || head.next == null) return true;
            Node current = head;
            while (current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    return false;
                }
                current = current.next;
            }
            return true;
        }
    }
}
