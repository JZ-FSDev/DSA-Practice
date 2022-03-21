public class HashTable {
    public class Node {
        public int item;
        public String key;
        public Node next;

        public Node(int newItem, String newKey, Node newNext) {
            item = newItem;
            key = newKey;
            next = newNext;
        }
    }

    private Node[] table;
    private static final int SIZE = 79;
    private static final int PRIME = 23;

    public HashTable(){
        table = new Node[SIZE];
    }

    public int hashFunction(String key){
        int hash = 0;
        if(key.length() > 1){
            hash = polynomialHashCode(key);
        }else{
            hash = Integer.parseInt(key) % SIZE;
        }

        return hash;
    }
}
