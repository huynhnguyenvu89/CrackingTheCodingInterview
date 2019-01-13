public class Main {

    public static void main(String[] args) {
        //Implementation of StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello world! \n");
        stringBuilder.append("This is a ");
        stringBuilder.append("StringBuilder implementation in Java");
        System.out.println(stringBuilder.toString());

        //Implementation of a HashTable
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("key 1", "value 1");
        hashTable.add("key 2", "value 2");
        hashTable.add("key 3", "value 3");
        hashTable.add("key 4", "value 4");
        hashTable.add("key 5", "value 5");
        hashTable.add("key 5", "value 6");
        hashTable.add("key 1", "value 10");
        System.out.println("HashTable size: " + hashTable.size());
        System.out.println(hashTable.get("key 5"));
        System.out.println(hashTable.remove("key 1"));
        System.out.println(hashTable.remove("key 1"));
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());

        //Implementation of an ArrayList
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("Array ");
        arrayList.add("List ");
        arrayList.add("Implementation");
        System.out.println("Check " + arrayList.get(1));
    }
}
