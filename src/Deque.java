public class Deque<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    public Deque(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size(first);
    }

    private int size(Node d){
        if (d == null)
            return 0;
        else
            return 1 + size(d.next);
    }

    public void pushLeft(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    public void pushRight(Item item){
        if (item == null)
            throw new NullPointerException();
        last = pushRight(last, item);
        if (size == 0)
            first = last;
        size++;
    }

    private Node pushRight(Node d, Item item){
        if (d == null){
            d = new Node();
            d.item = item;
            d.next = null;
            d.prev = null;
            return d;
        }else{
            d.next = pushRight(d.next, item);
            return d;
        }
    }

    public void popLeft(){
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        first = first.next;
        if (first == null)
            last = null;
        else
            first.prev = null;
        size--;
    }

    private Node popRight(Node d){
        if (d.next == null){
            d = null;
            return d;
        }else{
            d.next = popRight(d.next);
            return d;
        }
    }

    public void popRight(){
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        last = popRight(last);
        if (last == null)
            first = null;
        size--;
    }

    public Item left(){
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return first.item;
    }

    private Item right(Node d){
        if (d.next == null)
            return d.item;
        else
            return right(d.next);
    }

    public Item right() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return right(first);
    }
/*
    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        System.out.println(d.isEmpty());
        System.out.println(d.size());
        d.pushLeft("a");
        d.pushLeft("b");
        d.pushLeft("c");
        d.pushRight("d");
        d.pushRight("e");
        d.pushRight("f");
        d.popLeft();
        d.popRight();
        System.out.println(d.left());
        System.out.println(d.right());
        System.out.println(d.size());
        System.out.println(d.isEmpty());
    }
*/
}
