package linear;

public class PriorityQueue {
    private int[] values = new int[10];
    private int count;

    public void add(int value) {
        //
        // 7
        // [2, 5]

        if(count == 0) {
            values[count++] = value;
        }
        else {
            for (int i = count - 1; i >= 0; i--) {
                if (values[i] > value) {

                    values[i + 1] = values[i];

                } else if (values[i] <= value){

                    values[i + 1] = value;

                }

            }
            count++;
        }

    }

    public int[] getValues(){
        return values;
    }
}
