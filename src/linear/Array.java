package linear;

public class Array {

    private int[] numbers ;
    private int currentIndex = 0;

    public Array(int numberofElements) {
        this.numbers = new int[numberofElements];
    }



    public void insert(int number){
        if(currentIndex == numbers.length){
            copyElements();
        }
        numbers[currentIndex++] = number;

    }

    private void copyElements(){
        int[] copy = new int[numbers.length * 2];

        for (int i = 0; i < numbers.length; i++)
            copy[i] = numbers[i];

        numbers = copy;
    }

    public void removeAt(int index){

        if(index < 0 || index > numbers.length - 1)
            throw new IllegalArgumentException();

        int[] copy = new int[numbers.length - 1];

        for(int i = 0, j= 0; i < numbers.length; i++) {
            if(i != index)
                copy[j++] = numbers[i];
        }
        numbers = copy;

    }

    public int indexOf(int item) {
        for(int i = 0; i < numbers.length; i++ )
            if(numbers[i] == item)  return i;
        return -1;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
