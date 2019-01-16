import java.util.Arrays;

public class ArrayList<E> {

    private Object[] elements;
    private int DEFAULT_SIZE = 10;
    private int size;

    public ArrayList(){
        elements = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public void add(E e){
        //Add the new element on top of the existing array
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bound exception");
        }
        //Double the capacity if needed
        if (size == elements.length){
            int newSize = 2 * elements.length;
            elements = Arrays.copyOf(elements, newSize);
        }

        //In case of inserting new element at top
        if (index == size) elements[size++] = e;
        //In case of replacing the existing element
        else if (index < size) elements[index] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Out of bound exception");
        return (E) elements[index];
    }

    public int size(){
        return size;
    }
}
