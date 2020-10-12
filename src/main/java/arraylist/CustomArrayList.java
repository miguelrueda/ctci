package arraylist;

import java.util.Arrays;

public class CustomArrayList<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index " + i + ", Size " + size);
        }
        return (E) elements[i];
    }

    public void remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index " + i + ", Size " + size);
        }
//        while (i < size) {
//                E nextItem = (E) elements[i + 1];
//                elements[i] = nextItem;
//                i++;
//        }
        for (int j = i; j < size; j++) {
            elements[j] = elements[j + 1];
        }
        size--;
    }

    public void printList() {
        System.out.println(Arrays.toString(elements));
    }

    public static void main(String[] args) {
        CustomArrayList cal = new CustomArrayList();
        cal.add(1);
        cal.add(2);
        cal.add(3);
        cal.add(4);
        cal.add(5);

        cal.printList();

        System.out.println(cal.get(1));
        System.out.println(cal.get(3));

        cal.remove(2);
        cal.printList();
    }
}
