package linear;

import java.util.Arrays;

public class Stack {

    private int[] array;
    private int index ;
    private int size;

    public Stack(int size) {
        this.size = size;
        array = new int[size];
    }

    public void push(int number){
        if(isFull())
            increaseSize();

        array[index++] = number;
    }
    public int pop(){
        if(isEmpty())
            throw new IllegalArgumentException();

        int top = array[index];
        array[index--] = 0;
        return top;
    }

    private void increaseSize(){
        int[] arrayIncreased = new int[size * 2];

        for (int i = 0; i < size; i++)
            arrayIncreased[i] = array[i];

        array = arrayIncreased;
    }

    public int peak(){
        return array[index];

    }

    public boolean isEmpty(){
        return index == 0;
    }

    private boolean isFull(){
        return index == (size - 1);
    }

    @Override
    public String toString(){
        int[] arrayCopied = Arrays.copyOfRange(this.array, 0, index);
        return Arrays.toString(arrayCopied);
    }
}
