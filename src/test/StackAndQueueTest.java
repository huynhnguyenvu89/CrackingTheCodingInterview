package test;

import StackAndQueue.*;

public class StackAndQueueTest<T> {
    public StackAndQueueTest(){}

    public void runTestSuite(boolean active){
        if (!active)
            return;
        testStackImplementationUsingArray(false);
        testStackImplementationUsingLinkedList(false);
        testQueue(false);
        testStackThreeInOne(false);
        testStackMin(false);
        testSetOfStack(false);
        testMyQueue(false);
        testSortStack(false);
        testAnimalShelter(true);
    }

    private void testAnimalShelter(boolean active){
        if (!active)
            return;
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(AnimalShelter.CAT_TYPE_ID, "Happy");
        animalShelter.enqueue(AnimalShelter.CAT_TYPE_ID, "Na");
        animalShelter.enqueue(AnimalShelter.DOG_TYPE_ID, "Steve");
        animalShelter.enqueue(AnimalShelter.DOG_TYPE_ID, "Faisal");
        animalShelter.enqueue(AnimalShelter.DOG_TYPE_ID, "Vu");
        animalShelter.enqueue(AnimalShelter.CAT_TYPE_ID, "Pill");
        animalShelter.enqueue(AnimalShelter.DOG_TYPE_ID, "Woof");

        log("dequeueCat " + animalShelter.dequeueCat());
        log("dequeueDog " + animalShelter.dequeueDog());
        log("dequeueAny " + animalShelter.dequeueAny());
    }

    private void testSortStack(boolean active){
        if (!active)
            return;


    }

    private void testMyQueue(boolean active) {
        if (!active)
            return;
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.print();
        myQueue.remove();
        myQueue.print();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.print();
    }

    private void testSetOfStack(boolean active) {
        if (!active)
            return;

        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(6);
        setOfStacks.print();

        try {
            setOfStacks.pop();
            setOfStacks.print();
            setOfStacks.pop();
            setOfStacks.pop();
            setOfStacks.print();
            setOfStacks.pop();
            setOfStacks.pop();
            setOfStacks.print();

        } catch (IndexOutOfBoundsException e) {
            log("" + e.toString());
        }
    }

    private void testStackMin(boolean active) {
        if (!active)
            return;

        StackMin stackMin = new StackMin();
        stackMin.push(3);
        stackMin.push(4);
        stackMin.push(7);
        stackMin.push(1);

        log("Stack min value " + stackMin.min());
        stackMin.pop();
        stackMin.print();
        log("Stack min value " + stackMin.min());
        stackMin.pop();
        stackMin.pop();
        stackMin.print();
        log("Stack min value " + stackMin.min());
        stackMin.pop();
    }

    private void testStackThreeInOne(boolean active){
        if (!active)
            return;
        MultiStackInOneArray multiStackInOneArray = new MultiStackInOneArray(Integer.class, 3, 2, 5);

        try {
            log("Check first stack empty " + multiStackInOneArray.isEmpty(0));
            log("Check second stack empty " + multiStackInOneArray.isEmpty(1));
            log("Check third stack empty " + multiStackInOneArray.isEmpty(2));
            log("Check stack -1 empty " + multiStackInOneArray.isEmpty(-1));
        } catch (Exception e) {
            log("Intended exception " + e.toString());
        }

        try {
            multiStackInOneArray.pushToStack(1, 1);
            multiStackInOneArray.pushToStack(2, 1);
            multiStackInOneArray.pushToStack(3, 1);
        } catch (Exception e) {
            log("Intended exception " + e.toString());
        }

        try {
            log("Pop " + multiStackInOneArray.popFromStack(1));
            log("Pop " + multiStackInOneArray.popFromStack(1));
            log("Pop " + multiStackInOneArray.popFromStack(1));
        } catch (Exception e) {
            log("Intended exception " + e.toString());
        }
    }

    private void testQueue(boolean active) {
        if (!active)
            return;

        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(6);
        queue.add(10);
        queue.print();
        queue.remove();
        queue.print();
        try {
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.print();
        } catch (Exception e){
            log("Underflow expected!");
        }
    }

    private void testStackImplementationUsingLinkedList(boolean active) {
        if (!active)
            return;

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(1);
        stack.print();
        stack.pop();
        stack.print();
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.print();
        } catch (Exception e){
            log("Underflow expected!");
        }
    }

    private void log(String msg){
        MyLog.log(msg);
    }

    private void testStackImplementationUsingArray(boolean active){
        if (!active)
            return;
        log("TestArrayImplementationUsingArray");
        StackArray stack = new StackArray(Integer.class);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(1);
        stack.print();
        stack.pop();
        stack.print();
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.print();
        } catch (Exception e){
            log("Underflow expected!");
        }
    }


}
