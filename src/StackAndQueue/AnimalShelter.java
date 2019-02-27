package StackAndQueue;

import test.VPractive;

public class AnimalShelter extends VPractive {
    private AnimalQueue dogsQueue;
    private AnimalQueue catsQueue;
    public static int CAT_TYPE_ID = 100;
    public static int DOG_TYPE_ID = 200;
    private static int arrivalCounter = 0;

    public AnimalShelter() {
        arrivalCounter = 0;
        dogsQueue = new AnimalQueue();
        catsQueue = new AnimalQueue();
    }

    public void enqueue(int animalType, String animalName) {
        if(animalType == CAT_TYPE_ID){
            arrivalCounter++;
            catsQueue.add(animalName, arrivalCounter);
        } else if (animalType == DOG_TYPE_ID){
            arrivalCounter++;
            dogsQueue.add(animalName, arrivalCounter);
        } else {
            log("Invalid animal type");
        }
        log(animalName + " arrival order " + arrivalCounter);
    }

    public String dequeueCat(){
        if (catsQueue == null) {
            log("No cat found");
            return null;
        }
        return catsQueue.remove();
    }

    public String dequeueDog(){
        if (dogsQueue == null) {
            log("No dog found");
            return null;
        }
        return dogsQueue.remove();
    }

    public String dequeueAny(){
        AnimalNode oldestCat = catsQueue.peek();
        AnimalNode oldestDog = dogsQueue.peek();
        if (oldestCat == null && oldestDog== null){
            return null;
        } else if (oldestCat == null) {
            return oldestDog.animalName;
        } else if (oldestDog == null) {
            return oldestCat.animalName;
        } else {
            return (oldestCat.arrivalOrder < oldestDog.arrivalOrder)? oldestCat.animalName : oldestDog.animalName;
        }
    }

    class AnimalNode {
        String animalName;
        AnimalNode link;
        int arrivalOrder;

        AnimalNode(String animalName, int arrivalOrder) {
            this.animalName = animalName;
            this.arrivalOrder = arrivalOrder;
            link = null;
        }
    }

    class AnimalQueue {
        AnimalNode head;
        AnimalNode tail;

        AnimalQueue() {
            head = null;
        }

        public void add(String animalName, int arrivalOrder){
            AnimalNode animalNode = new AnimalNode(animalName, arrivalOrder);

            if (tail != null){
                tail.link = animalNode;
            }
            tail = animalNode;
            if (head == null) {
                head = tail;
            }
        }

        public String remove(){
            AnimalNode temp = head;
            head = head.link;
            return temp.animalName;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public AnimalNode peek(){
            return head;
        }
    }
}
