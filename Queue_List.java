// Implementation of Queue with Linked List
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

package learning.Queue;

public class QueueList<Object> {
    Node front, rear;
    
    public void add(Object element){
        Node newNode = new Node(element);
        if(front == null){
            rear = front = newNode;
            return;
        }
        rear.nextNode = newNode;
        rear = newNode;
    }
    
    public Object pool(){
        
        if(front == null){
            System.out.println("Queue Underflow!");
            return (Object)null;
        }
        
        else{
            Node curNode = front;
            front = front.nextNode;
            curNode.nextNode = null;
            return (Object)(curNode.data);
        }
    }
    
    public Object peek(){
        Object obj = null;
        if(front != null){
            return (Object) front.data;
        }
        return obj;
    }
    
    public void printQueue(){
        if(front == null){
            System.out.println("The Queue is empty!");
        }
        else{
            Node pointNode = front;
            while(pointNode.nextNode != null){
                System.out.print(pointNode.data + " ");
                pointNode = pointNode.nextNode;
            }
            System.out.println(pointNode.data);
        }
    }
    public static void main(String[] args) {
//        QueueList<String> q = new QueueList<>();
//        q.add("miraz");
//        q.add("rakib");
//        q.add("Rashed");
////        q.pool();
//        System.out.println(q.peek());
//        q.printQueue();
        QueueList<Integer> q = new QueueList<>();
        q.add(0);
        q.add(1);
        q.add(2);
        q.pool();
        System.out.println(q.pool());
        System.out.println(q.peek());
        q.printQueue();
    }
}
