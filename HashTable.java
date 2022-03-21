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
    
        public int polynomialHashCode(String key) {
        int hash = key.charAt(0);
        for(int i = 0; i < key.length() - 1; i++){
            hash = (hash * PRIME + key.charAt(i + 1)) % SIZE;
        }
        return hash;
    }

    public Node search(String variableName){
        Node node = null;
        int index = hashFunction(variableName);
        if(table[index] != null){
            Node curr = table[index];
            boolean found = false;
            while(curr != null && !found){
                if(curr.key.equals(variableName)){
                    node = curr;
                    found = true;
                }
                curr = curr.next;
            }
        }
        return node;
    }
    
        /**
     * 
     * 
     * @param variableName
     * @param newValue
     */
    public void insert(String variableName, int newValue){
        int index = hashFunction(variableName);
        Node curr = table[index];
        if(curr == null){
            table[index] = new Node(newValue, variableName, null);
        }else{
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(newValue, variableName, null);
        }
    }

    /**
     * Prints the entire hash table along with its elements.
     */
    public void printVariables(){
        for(int i = 0; i < SIZE; i++){
            String s = "Index " + i + ": ";
            Node curr = table[i];
            while(curr != null){
                s += " key: " + curr.key + " " + " item: " + curr.item;
                curr = curr.next;
            }
            System.out.println(s);
        }
    }
}
