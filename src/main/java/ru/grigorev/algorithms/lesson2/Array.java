package ru.grigorev.algorithms.lesson2;

/**
 * @author Dmitriy Grigorev
 */
public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        if (size == 0)
            arr = new int[10];
        else
            this.arr = args;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    public void fillRandomValues(int values) {
        deleteAll();
        for (int i = 0; i < values; i++) {
            this.append((int) (Math.random() * 100));
        }
    }

    public int findMax() {
        if (size == 0) throw new RuntimeException("array is empty!");
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (size == 0) return false;
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException(index);
        int[] temp = new int[--size];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) j++;
            temp[i] = arr[j];
        }
        arr = temp;
        return true;
    }

    boolean deleteAll(int value) { // by value
        if (size == 0) return false;
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (value == arr[i]) {
                delete(i);
                isFound = true;
            }
        }
        return isFound;
    }

    void deleteAll() { // clear array
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    public void sortBubbleImproved() {
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true; // still O(n^2)
    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

    public void sortCount() { // O(n^3) ???
        int[] countArr = new int[findMax()]; //O(n)
        for (int i = 0; i < size; i++) { // O (n)
            countArr[arr[i] - 1]++;
        }
        for (int i = 0, insertNum = 1 , pos = 0; i < countArr.length; i++) { //O(n)
            for (int j = 0; j < countArr[i]; j++) {
                arr[pos] = insertNum;
                pos++;
            }
            insertNum++;
        }
    }

}
