package linear;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value){

        Node node = new Node(value);

        if (first == null) {
            first = node;
            last = node;
        }
        else {
            node.setNext(first);
            first = node;
        }
        size++;
    }

    public void addLast(int value){

        Node node = new Node(value);

        if(last == null) {
            first = node;
            last = node;
            System.out.println("added to last item");
        }
        else {
            last.setNext(node);
            last = node;
        }

        size++;

    }

    public void deleteFirst(){
        Node next = first.getNext();

        first.setNext(null);

        first = next;

        size--;
    }

    public void deleteLast(){

        Node beforeLast = first;

        while(beforeLast.getNext() != null){

            Node node = beforeLast.getNext();

            if(node.getNext() == null) {
                remove(beforeLast);
                break;
            }

            beforeLast = beforeLast.getNext();

        }

        size--;
    }

    private void remove(Node beforeLast){
        beforeLast.setNext(null);
        last = beforeLast;
    }

    public boolean contains(int value){
        Node node = first;

        while (node != null){

            if (node.getValue() == value)
                return true;

            node = node.getNext();
        }

        return false;
    }

    public int indexOf(int value){

        int index = 0;
        Node node = first;

        while (node != null){
            if (node.getValue() == value)
                return index;

            node = node.getNext();
            index++;

        }

        return -1;
    }

    public String toString() {
        String arrayInString  =  "[";

        Node node = first;

        while (node != null){

            arrayInString +=  node.getValue();

            if(node == last)
                arrayInString = ",";

            node = node.getNext();
        }

        arrayInString += "]";

        return arrayInString;

    }

    public int getSize(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];

        Node current = first;
        int index = 0;
        while (current != null){

            array[index] = current.getValue();
            current = current.getNext();
            index++;
        }

        return array;

    }

    public void reverse(){

        if(isEmpty()) return;

        Node prev = first;
        Node current = first.getNext();
        Node next;
        while(current!= null) {

            next = current.getNext();
            current.setNext(prev);

            prev = current;

            current = next;

        }
        last = first;
        last.setNext(null);
        first = prev;

    }

    private boolean isEmpty() {
        return size == 0;
    }



    public int kthNode(int k){

        if(isEmpty())
            throw new IllegalArgumentException();


        Node current = first;
        Node next = first;

        for(int i = 0; i < k -1; i++ ) {
            next = next.getNext();

            if (next == null)
                throw new IllegalArgumentException();
        }


        while (next != last){

            current = current.getNext();
            next = next.getNext();

        }

        return current.getValue();
    }

}
