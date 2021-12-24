// implementatin of singly linked list in java 

package learning;

public class Node {
     int data;
     Node nextNode;

    public Node(int d) {
        data = d;
        nextNode = null;
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
    
     
}

package learning;

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
        }
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("The List is Empty!");

        } else if (head.data == key) {
            head = head.nextNode;
            return;
        } else {
            Node pointerNode = head;
            Node preNode = null;
            while (pointerNode.nextNode != null) {
                if (pointerNode.data == key) {
                    preNode.nextNode = pointerNode.nextNode;
                    return;
                }
                preNode = pointerNode;
                pointerNode = pointerNode.nextNode;
            }
            if (pointerNode.data == key) {
                preNode.nextNode = null;
                return;
            }
        }
        System.out.println(key + " is Not Found..");
    }

    public void find(int key) {
        Node pointerNode = head;
        if (head == null) {
            System.out.println("The List is Empty!");
        } else {
            while (pointerNode.nextNode != null) {
                if (pointerNode.data == key) {
                    System.out.println(key + " is found.");
                }
                pointerNode = pointerNode.nextNode;
            }
            if (pointerNode.data == key) {
                System.out.println(key + " is found.");
            }

        }

    }

    public void printList() {
        if (head == null) {
            System.out.println("The List is Empty!");
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
//        LinkedList list2 = new LinkedList();
//        list2.add(3);
//        list2.add(4);
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(5);
//        System.out.println("head " + list.head.data);
        list.printList();
//        list.delete(0);
        list.find(2);
        list.printList();
//        list2.printList();
    }
}
