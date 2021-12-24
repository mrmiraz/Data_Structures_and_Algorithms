// Implementation of Doubly Linked List

package learning.DoublyLinkedList;

public class Node {
    int data;
    Node nextNode;
    Node preNode;

    public Node(int d) {
        data = d;
        nextNode = null;
        preNode = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreNode() {
        return preNode;
    }

    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }
    
    
}

package learning.DoublyLinkedList;

public class LinkedList {

    Node head;

    public void add(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node pointerNode = head;
            while (pointerNode.nextNode != null) {
                pointerNode = pointerNode.nextNode;
            }
            pointerNode.nextNode = newNode;
            newNode.preNode = pointerNode;
        }
    }

    // deleting data from linked list 
    public void delete(int key) {
        if (head == null) {
            System.out.println("The list is empty.");
        } else if (head != null && key == head.data) {
            head = head.nextNode;
            head.preNode = null;
            return;
        } else {
            Node pointerNode = head;

            while (pointerNode.nextNode != null) {
                if (pointerNode.data == key) {
                    Node preNode = pointerNode.preNode;
                    Node nextNode = pointerNode.nextNode;
                    preNode.nextNode = nextNode;
                    nextNode.preNode = preNode;
                    return;
                }
                pointerNode = pointerNode.nextNode;
            }
            if (pointerNode.data == key) {
                Node preNode = pointerNode.preNode;
                preNode.nextNode = null;
                return;
            }
        }
        System.out.println(key + " is not found");
    }

    // Finding the interested value
    public void find(int key) {
        if (head == null) {
            System.out.println("The List is empty.");
        } else {
            Node pointerNode = head;
            while (pointerNode.nextNode != null) {
                if (key == pointerNode.data) {
                    System.out.println(key + " is found.");
                    return;
                }
                pointerNode = pointerNode.nextNode;
            }
            if (pointerNode.data == key) {
                System.out.println(key + " is found");
                return;
            }

        }

        System.out.println(key + " is not found.");
    }

    public boolean isEmpty() {
        if (head.nextNode == null) {
            return true;
        } else {
            return false;
        }
    }

    // printing linked List
    public void printList() {
        if (head == null) {
            System.out.println("The List is empty.");
        } else {
            Node pointerNode = head;
            while (pointerNode.nextNode != null) {
                System.out.print(pointerNode.data + " ");
                pointerNode = pointerNode.nextNode;
            }
            System.out.println(pointerNode.data);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.printList();
        list.delete(0);
        list.find(3);
        list.printList();

    }
}
