/**
 * Defines a hash table implemented using Nodes with separate chaining
 * to resolve collisions. Horner's method used to generate polynomial
 * hash code.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
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

    /**
     * Creates a new hash table of SIZE elements.
     */
    public HashTable() {
        table = new Node[SIZE];
    }

    /**
     * Converts the specified string into its polynomial hash code using
     * Horner's method if the key is larger than one character.
     * 
     * @param string The String to be converted into its hash code.
     * @return The hash code of the given string.
     */
    public int hashFunction(String string) {
        int hash = 0;

        if (string.length() > 1) {
            hash = (int) string.charAt(0);
            for (int i = 0; i < string.length() - 1; i++) {
                hash = (hash * PRIME + string.charAt(i + 1)) % SIZE;
            }
        }
        return hash;
    }

    /**
     * Searches for the Node with the matching specified key and returns it.
     * Returns null if it is not found.
     * 
     * @param key The key to of the Node to be searched for.
     * @return Returns the the Node with the matching specified key.
     */
    public Node search(String key) {
        Node node = null;
        int index = hashFunction(key);
        if (table[index] != null) {
            Node curr = table[index];
            boolean found = false;
            while (curr != null && !found) {
                if (curr.key.equals(key)) {
                    node = curr;
                    found = true;
                }
                curr = curr.next;
            }
        }
        return node;
    }

    /**
     * Inserts a new entry into the hash table of specified String key and its
     * associated int item value.
     * 
     * @param key      The key of the new entry.
     * @param newValue The int value of the new entry.
     */
    public void insert(String key, int newValue) {
        int index = hashFunction(key);
        Node curr = table[index];
        if (curr == null) {
            table[index] = new Node(newValue, key, null);
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(newValue, key, null);
        }
    }

    /**
     * Prints the entire hash table along with its elements.
     */
    public void printVariables() {
        for (int i = 0; i < SIZE; i++) {
            String s = "Index " + i + ": ";
            Node curr = table[i];
            while (curr != null) {
                s += " key: " + curr.key + " " + " item: " + curr.item;
                curr = curr.next;
            }
            System.out.println(s);
        }
    }
}
