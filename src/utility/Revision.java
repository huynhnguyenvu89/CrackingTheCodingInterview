package utility;

import java.util.ArrayList;
import java.util.Arrays;

public class Revision {

    public class ArrayList<E> {
        private Object[] elements;
        private int DEFAULT_SIZE = 10;
        private int size;
        public ArrayList(){
            elements = new Object[DEFAULT_SIZE];
            size = 0;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size() == 0;
        }

        public void add(E e){
            add(e, size - 1);
        }

        public void add(E e, int index) {
            checkInputIndex(index);

            //Ensure capacity
            if (size == elements.length){
                int newSize = elements.length * 2;
                elements = Arrays.copyOf(elements, newSize);
            }

            if (index == size - 1){
                elements[size++] = e;
            } else {
                elements[index] = e;
            }
        }

        public E get(int index){
            checkInputIndex(index);
            return (E) elements[index];
        }

        private void checkInputIndex(int index){
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index out of bound exception");
        }
    }

    /**\
     * Assuming string in ASCII, 128 characters
     * Assuming space counts
     */
    public boolean checkPermutation(String s, String t) {
        //Permutation have the same length
        if (s.length() != t.length())
            return false;

        int[] character = new int[128];
        for (int i = 0; i < s.length(); i ++){
            character[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++){
            character[t.charAt(i)]--;
            if (character[t.charAt(i)] < 0)
                return false;
        }

        return true;
    }

    /**
     * Assumption 1: ASCII character, size 128
     */
    public boolean isUnique(String input){
        if (input.length() > 128)
            return false;
        int[] characters = new int[128];
        for (int i = 0; i < input.length(); i ++){
            characters[input.charAt(i)]++;
            if (characters[input.charAt(i)] > 1)
                return false;
        }
        return true;
    }

    /**
     * Assumption 1: ASCII character, size 128
     */
    public boolean isUnique2(String input){
        if (input.length() > 128)
            return false;
        boolean[] check = new boolean[128];
        for (int i = 0; i < input.length(); i ++){
            if (check[input.charAt(i)])
                return false;
            check[input.charAt(i)] = true;
        }
        return true;
    }

    public class StringBuilder {
        private char[] values;
        private int DEFAULT_SIZE = 10;
        private int size;

        public StringBuilder(){
            values = new char[DEFAULT_SIZE];
            size = 0;
        }

        public void append(String input) {
            //Check input validity
            if(input == null || input.length() == 0)
                return;

            //Ensure capacity
            if ((size + input.length()) > values.length) {
                int newSize = values.length * 2;
                values = Arrays.copyOf(values, newSize);
            }

            for (int i = 0; i < input.length(); i ++) {
                values[size++] = input.charAt(i);
            }
        }

        @Override
        public String toString() {
            return new String(values);
        }
    }

    class HashTable<K, V> {
        private ArrayList<HashNode<K, V>> nodeBucket;
        private int DEFAULT_SIZE = 10;
        private int DEFAULT_COMPRESSOR = 10;
        private int size;
        private double THRESHOLD_RATIO = 0.7;

        public HashTable(){
            initNodeBucket(DEFAULT_SIZE);
            size = 0;
        }

        public void put(K key, V value) {
            if (key == null || value == null)
                return;

            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> headNode = nodeBucket.get(bucketIndex);

            while (headNode != null) {
                if (headNode.key.equals(key)){
                    headNode.value = value;
                    return;
                }
                headNode = headNode.next;
            }

            //Add new node to the beginning of the chain
            size ++;
            HashNode<K, V> newNode = new HashNode<>(key, value);
            headNode = nodeBucket.get(bucketIndex);
            newNode.next = headNode;
            nodeBucket.add(newNode, bucketIndex);

            //Ensure capacity
            double crrRatio = (1.0 * size)/nodeBucket.size();
            if (crrRatio > THRESHOLD_RATIO) {
                int newSize = nodeBucket.size() * 2;
                ArrayList<HashNode<K, V>> temp = nodeBucket;
                initNodeBucket(newSize);
                for (int i = 0; i < temp.size(); i ++){
                    HashNode<K,V> head = temp.get(i);
                    while (head != null){
                        put(head.key, head.value);
                        head = headNode.next;
                    }
                }
            }
        }

        public V get(K key){
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> head = nodeBucket.get(bucketIndex);

            while (head != null){
                if (head.key.equals(key))
                    return head.value;
                head = head.next;
            }
            return null;
        }

        public V remove(K key){
            int bucketIndex = getBucketIndex(key);

            HashNode<K, V> head = nodeBucket.get(bucketIndex);
            HashNode<K, V> previous = null;
            while (head != null){
                if (head.key.equals(key))
                    break;
                previous = head;
                head = head.next;
            }

            if (head == null)
                return null;

            if (previous != null){
                previous.next = head.next;
            } else {
                nodeBucket.add(head.next, bucketIndex);
            }

            return head.value;
        }

        public int getBucketIndex(K key){
            return key.hashCode() % DEFAULT_COMPRESSOR;
        }

        private void initNodeBucket(int size){
            nodeBucket = new ArrayList<>();
            for (int i = 0; i < size; i ++)
                nodeBucket.add(null);
        }

        class HashNode<K, V> {
            public HashNode next;
            public K key;
            public V value;
            public HashNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
    }

    public static String urlify(String input){
        char[] inputArray = input.trim().toCharArray();

        int spaceCount =0, i;

        for (i = 0; i < inputArray.length; i ++){
            if (inputArray[i] == ' ') spaceCount ++;
        }
        if(spaceCount == 0)
            return input;

        int newLength = inputArray.length + spaceCount * 2;
        char[] output = new char[newLength];

        for (i = inputArray.length - 1; i >= 0; i --){
            char c = inputArray[i];
            if (c == ' '){
                output[newLength - 1] = '0';
                output[newLength - 2] = '2';
                output[newLength - 3] = '%';
                newLength -= 3;
            } else {
                output[--newLength] = c;
            }
        }
        return new String(output);
    }
}
