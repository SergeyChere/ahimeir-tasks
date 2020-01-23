package service.stack;

import java.util.ArrayList;

public class MyStackStructure {
    private static int maxSize = 10;
    private static ArrayList list = new ArrayList();
    private static int lastValue;

    public MyStackStructure() {}

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private int getLastValue() {
        return (int) list.get(list.size()-1);
    }

    private void setLastValue(int lastValue) {
        this.lastValue = lastValue;
    }

    public boolean push(int i) {
        if (list.size() == maxSize) {
            return false;
        } else {
            setLastValue(i);
            list.add(lastValue);
        }
        return true;
    }

    public int peek() {
        return getLastValue();
    }

    public int pop() {
        int temp = 0;
        if (!list.isEmpty()) {
            temp = (int) list.get(list.size()-1);
            list.remove(list.size()-1);
            if (!list.isEmpty()) {
                setLastValue((int) list.get(list.size()-1));
            }
        }
        return temp;
    }
}
