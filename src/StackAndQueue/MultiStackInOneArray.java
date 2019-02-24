package StackAndQueue;

import test.VPractive;

import java.lang.reflect.Array;

/**
 * Three In One: Describe how could you use a single array to implement three stacks.
 * @param <T>
 */
public class MultiStackInOneArray<T> extends VPractive {
    private int MAX = 0;
    //The single array to store all stacks' elements.
    private T[] elements;
    //An array to store information about stacks, this enable flexibility when create stacks with different sizes.
    private StackInfo[] stacks;

    //Private inner class holds information about each inner Stacks
    private class StackInfo {
        private int stackSize;
        private int currentSize;
        private int startingElementIndex = 0;
        private int currentElementIndex = 0;
        private int endingElementIndex = 0;

        public StackInfo(int stackSize){
            this.stackSize = stackSize;
            startingElementIndex = 0;
            currentElementIndex = 0;
            endingElementIndex = 0;
        }

        protected void setStartingElementIndex(int startingIndex){
            this.startingElementIndex = startingIndex;
            currentElementIndex = startingIndex;
            this.endingElementIndex = startingIndex + stackSize - 1;
        }

        protected void push(){
            if (currentSize > stackSize)
                throw new IndexOutOfBoundsException("Stack full - Overflow Exception");
            currentSize ++;
            currentElementIndex ++;
        }

        protected void pop(){
            if (currentSize < 0)
                throw new IndexOutOfBoundsException("Underflow condition");
            currentSize --;
            currentElementIndex --;
        }

        protected boolean isEmpty(){
            return currentSize == 0;
        }
    }

    public MultiStackInOneArray(Class<T> clazz, int ... stackSizes){
        stacks = (StackInfo[]) Array.newInstance(StackInfo.class, stackSizes.length);

        for (int i = 0; i < stackSizes.length; i ++){
            StackInfo stackInfo = new StackInfo(stackSizes[i]);
            stackInfo.setStartingElementIndex(MAX);
            MAX += stackSizes[i];
            stacks[i] = stackInfo;
        }
        elements = (T[]) Array.newInstance(clazz, MAX);
    }

    private StackInfo getValidStack(int stackIndex) {
        if (MAX == 0 || stacks == null || elements == null
                || stackIndex < 0 || stackIndex > stacks.length)
            throw new IndexOutOfBoundsException("No such stack found");
        StackInfo res = stacks[stackIndex];
        log("Current element index " + res.currentElementIndex + " - Ending: " + res.endingElementIndex);
        return stacks[stackIndex];
    }

    public boolean isEmpty(int stackIndex) throws IndexOutOfBoundsException {
        return getValidStack(stackIndex).isEmpty();
    }

    public void pushToStack(T element, int stackIndex) throws IndexOutOfBoundsException {
        StackInfo stackInfo = getValidStack(stackIndex);
        if (stackInfo.currentElementIndex > stackInfo.endingElementIndex)
            throw new IndexOutOfBoundsException("Overflow condition");

        elements[stackInfo.currentElementIndex] = element;
        stackInfo.push();
        log("Push " + element + " to Stack Index " + stackIndex);
    }

    public T popFromStack(int stackIndex) throws IndexOutOfBoundsException {
        StackInfo stackInfo = getValidStack(stackIndex);
        stackInfo.pop();
        if (stackInfo.currentElementIndex < stackInfo.startingElementIndex)
            throw new IndexOutOfBoundsException("Underflow condition");

        T res = elements[stackInfo.currentElementIndex];
        log("Pop " + res + " from Stack Index " + stackIndex);
        return res;
    }
}
