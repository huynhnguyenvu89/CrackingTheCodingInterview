package StackAndQueue;

import test.MyLog;

import java.lang.reflect.Array;

public class StackArray<T> {
    private T[] elements;
    private final int MAX = 1000;
    private int top = 0;

    public StackArray(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX);
    }

    private boolean isEmpty() {
        return (top > 0);
    }

    public T pop(){
        if (top < 0)
            throw new ArrayIndexOutOfBoundsException("Underflow condition, array index out of bound");
        return elements[top--];
    }

    public void push(T element) {
        if (top > MAX)
            throw new StackOverflowError("Stack overflow condition");
        elements[top++] = element;
    }

    public T peek(){
        if (top < 0 || top > MAX)
            throw new ArrayIndexOutOfBoundsException("Array index out of bound");
        return elements[top - 1];
    }

    public void print(){
        log("*** Print Start. Stack Size: " + top);
        for (int i = 0; i < top - 1; i ++){
            logInLine(elements[i] + " ==> ");
        }
        log(peek() + "");
    }

    private void log(String msg) {
        MyLog.log( msg);
    }

    private void logInLine(String msg) {
        MyLog.logInLine( msg);
    }
}
