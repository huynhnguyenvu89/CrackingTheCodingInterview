import java.util.Arrays;

public class ArrayList<E> {
    private Object[] elements;
    private final int DEFAULT_SIZE = 10;
    private int size = 0;

    public ArrayList(){
        elements = new Object[DEFAULT_SIZE];
    }

    public void add(E e){
        if (size == elements.length){
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
        elements[size++] = e;
    }

    public E get(int index){
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Out of bound");
        }
        return (E) elements[index];
    }
}
