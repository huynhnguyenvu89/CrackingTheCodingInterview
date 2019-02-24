package StackAndQueue;

import test.VPractive;

import java.lang.reflect.Array;

/**
 * Three In One: Describe how could you use a single array to implement three stacks.
 * @param <T>
 */
public class StackThreeInOne<T> extends VPractive {
    private int MAX = 0;
    private T[] elements;

    public StackThreeInOne(Class<T> clazz, int a, int b, int c) {
        MAX = a + b + c;
        elements = (T[]) Array.newInstance(clazz, MAX);
    }
}
