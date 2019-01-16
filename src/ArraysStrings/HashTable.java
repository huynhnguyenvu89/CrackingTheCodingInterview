package ArraysStrings;

import java.util.ArrayList;

public class HashTable<K, V> {

    private ArrayList<HashNode<K, V>> bucketArray;
    private int numberOfBucket;
    private int size;
    private final double LOAD_FACTOR_THRESHOLD = 0.7;

    public HashTable(){
        bucketArray = new ArrayList<>();
        numberOfBucket = 10;
        size = 0;
        //Create an empty chain
        for (int i = 0; i < numberOfBucket; i ++) {
            bucketArray.add(null);
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        //Apply the hash function to find index for given key
        int bucketIndex = getBucketIndex(key);

        //Get head of chain
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        //To overriding the existing Key Value pair
        while (head != null) {
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        //Insert key in chain
        size ++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.add(bucketIndex, newNode);

        //If the load factor exceeds the threshold, then double the hash table size
        if ((1.0 * size())/numberOfBucket >= LOAD_FACTOR_THRESHOLD) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numberOfBucket *= 2;
            size = 0;

            for (int i = 0; i < numberOfBucket; i ++) {
                bucketArray.add(null);
            }
            for (HashNode<K, V> headNode : temp){
                while (headNode != null){
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        //Search for Node with given key
        HashNode<K, V> previous = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            previous = head;
            head = head.next;
        }

        //If there is no Node with given key
        if (head == null) {
            return null;
        }

        //Reduce size
        size --;

        //Remove Node with given Key
        if (previous != null){
            previous.next = head.next;
        } else {
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode % numberOfBucket);
    }

    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}