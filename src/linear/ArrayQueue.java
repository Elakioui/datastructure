package linear;

import java.util.Queue;

public class ArrayQueue {

    private int[] array;
    private int first;
    private int rearward;
    private int index;

    public ArrayQueue(int size) {
        this.array = new int[size];
    }

    public void enqueue(int value) {
        array[index] = value;

        if(first == rearward && index == 0) {
            first = array[index];
            rearward = first;
        }
        else rearward = array[index];

        index++;

    }

    public int[] getArray() {
        return array;
    }
}
