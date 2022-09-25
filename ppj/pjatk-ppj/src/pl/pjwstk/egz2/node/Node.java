package pl.pjwstk.egz2.node;

public class Node {
    Node next;
    int val;

    public Node(int val){
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}
