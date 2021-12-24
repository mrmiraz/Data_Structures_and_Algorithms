package codefoces;

import java.util.*;

public class PriorityQueue2 {

    public void swap(ArrayList<Integer> array, int index1, int index2) {
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }
    
    public int getLeftChildIndex(ArrayList<Integer> array, int index) {
        if ((2 * index + 1) < array.size() && index >= 0) {
            return 2 * index + 1;
        }
        return -1;
    }

    public int getRightChildIndex(ArrayList<Integer> array, int index) {
        if ((2 * index + 2) < array.size() && index >= 0) {
            return 2 * index + 2;
        }
        return -1;
    }

    public void minHeapifyAfterDeletion(ArrayList<Integer> array, int index) {
        int leftChildIndex = getLeftChildIndex(array, index);
        int rightChildIndex = getRightChildIndex(array, index);
        int minValueIndex = index;
        if (leftChildIndex < array.size() && leftChildIndex > 0) {
            if (array.get(leftChildIndex) < array.get(minValueIndex)) {
                minValueIndex = leftChildIndex;
            }
		if (rightChildIndex < array.size() && rightChildIndex > 0) {
                if (array.get(rightChildIndex) < array.get(minValueIndex)) {
                    minValueIndex = rightChildIndex;
                }
            }
        }
        if (minValueIndex != index) {
            swap(array, minValueIndex, index);
            minHeapifyAfterDeletion(array, minValueIndex);
        }
    }

    public void minHeapifyAfterInsertion(ArrayList<Integer> array, int parentIndex){
        
    }
    public void insert(ArrayList<Integer> array, int newNum) {
        if (array.isEmpty()) {
            array.add(newNum);
        } else {
            array.add(newNum);
            int currentIndex = array.size() - 1;
            int parentIndex = (currentIndex - 1) / 2;
            int parent = array.get(parentIndex);
            int child = newNum;
            int childIndex = array.size() - 1;
            while (parent > child) {
                swap(array, parentIndex, childIndex);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
                parent = array.get(parentIndex);
                child = array.get(childIndex);
            }
        }
    }

    public void delete(ArrayList<Integer> array) {

        if (array.isEmpty()) {
            System.out.println("The Queue Is Empty!");
        } else {
            swap(array, 0, array.size() - 1);
            array.remove(array.size() - 1);
            minHeapifyAfterDeletion(array, 0);
            System.out.println("Succesfully Deleted!");
        }
    }
    
    public int find(ArrayList<Integer> array){
        if(array.isEmpty()){
            return 0;
        }
        return array.get(0);
    }

    public static void printHeap(ArrayList<Integer> array) {
        System.out.print("\n");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue2 pq = new PriorityQueue2();
        ArrayList<Integer> array = new ArrayList<>();
        while (true) {
            System.out.println("For Insert: press 1..\n"
                    + "For Find: press 2..\n"
                    + "For Delete: press 3..");
            int choosenNumber = sc.nextInt();

            if (choosenNumber == 1) {
                System.out.println("Enter data to insert: ");
                int data = sc.nextInt();
                pq.insert(array, data);
            } else if (choosenNumber == 2) {
                
                if(array.isEmpty()){
                    System.out.println("The Queue Is Empty!");
                }
                else{
                    System.out.println(pq.find(array));
                }

            }
            else if(choosenNumber == 3){
                pq.delete(array);
            }
            printHeap(array);
        }
        
    }
}
