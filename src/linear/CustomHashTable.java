package linear;

import java.util.LinkedList;

public class CustomHashTable {
    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){

        int index = hashCode(key);
        LinkedList<Entry> items;

        if (entries[index] == null){
            items  = new LinkedList<>();
            items.addLast(new Entry(key, value));
            entries[index] = items;
            return;
        }

        items = entries[index];

        for (Entry item : items){
            if (item.getKey() == key) {
                item.setValue(value);
                return;
            }
        }

        entries[index].addLast(new Entry(key, value));

    }

    public String get(int key){

        if (key < 0)
            throw new IllegalArgumentException();

        LinkedList<Entry> items = entries[hashCode(key)];

        if (items != null)
            for(Entry item : items)
                if (item.getKey() == key)
                    return item.getValue();

        return null;
    }

    public void remove(int key){
        int index = hashCode(key);

        LinkedList<Entry> items = entries[index];

        if (items == null)
            throw new IllegalArgumentException();

        for(int i = 0; i < items.size(); i++ )
            if (items.get(i).getKey() == key) {
                items.remove(i);
                return;
            }

        throw new IllegalArgumentException();

    }

    public int hashCode(int key){
        return Math.abs(key) % entries.length;
    }


}
