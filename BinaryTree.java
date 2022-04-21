import java.util.NoSuchElementException;

/**
 * Defines a Binary Tree with its basic operations.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class BinaryTree {

    public class Node {
        public int item;
        public Node right;
        public Node left;

        public Node(int newItem) {
            item = newItem;
            right = null;
            left = null;
        }

        private int numberOfNodes(Node curr) {
            int num = 0;
            if (curr != null) {
                num++;
                if (curr.left != null) {
                    num += numberOfNodes(curr.left);
                }
                if (curr.right != null) {
                    num += numberOfNodes(curr.right);
                }
            }
            return num;
        }
    }

    private Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        System.out.println(tree.isValid(tree.root));
    }

    /**
     * Creates a new Binary Tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Inserts the specified item into this Binary Tree.
     * 
     * @param item The int to be added to the Binary Tree.
     */
    public void insert(int item) {
        if (root == null) {
            root = new Node(item);
        } else {
            Node node = new Node(item);
            Node curr = root;
            Node prev = root;
            while (curr != null) {
                if (item < curr.item) {
                    prev = curr;
                    curr = curr.left;
                } else {
                    prev = curr;
                    curr = curr.right;
                }
            }
            if (item > prev.item) {
                prev.right = node;
            } else {
                prev.left = node;
            }
        }
    }

    /**
     * Searches for the specified key in this Binary Tree and returns
     * true if it is found.
     * 
     * @param key The int to be searched for.
     * @return True if the specified key is found in this Binary Tree.
     */
    public boolean search(int key) {
        Node curr = root;
        boolean found = false;
        while (curr != null && !found) {
            if (key == curr.item) {
                found = true;
            } else if (key > curr.item) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return found;
    }

    /**
     * Searches for the Node containing the specified key in this Binary
     * Tree and returns it if it is found. Returns null if not found.
     * 
     * @param key The int of a Node to be searched for.
     * @return The Node containing the specified key.
     */
    public Node searchNode(int key) {
        Node curr = root;
        boolean found = false;
        while (curr != null && !found) {
            if (key == curr.item) {
                found = true;
            } else if (key > curr.item) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return curr;
    }

    /**
     * Searches for the Node containing the specified key in this Binary
     * Tree and returns it if it is found. Returns null if not found.
     * 
     * @param root The root of this Binary Tree.
     * @param key  The int of a Node to be searched for.
     * @return The Node containing the specified key.
     */
    public boolean searchRecursive(Node root, int key) {
        boolean found = (key == root.item);
        if ((root.left != null || root.right != null) && !found) {
            if (key > root.item) {
                found = searchRecursive(root.right, key);
            } else {
                found = searchRecursive(root.left, key);
            }
        }
        return found;
    }

    /**
     * Inserts the given item into this Binary Tree.
     * 
     * @param prev Pointer to the node previous to the current Node.
     * @param curr The root of the Binary Tree.
     * @param item The int to be inserted.
     */
    public void insertRecursive(Node prev, Node curr, int item) {
        if (curr != null) {
            if (item < curr.item) {
                insertRecursive(curr, curr.left, item);
            } else {
                insertRecursive(curr, curr.right, item);
            }
        } else {
            if (root == null) {
                root = new Node(item);
            } else {
                Node node = new Node(item);
                if (item > prev.item) {
                    prev.right = node;
                } else {
                    prev.left = node;
                }
            }
        }
    }

    /**
     * Deletes the given key from this Binary Tree.
     * 
     * @param key The int to be deleted.
     */
    public void delete(int key) {
        Node prev = null;
        Node curr = root;
        boolean found = false;
        while (curr != null && !found) {
            if (key == curr.item) {
                found = true;
            } else if (key > curr.item) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }
        if (found) {
            if (curr.left == null && curr.right == null) { // leaf case
                if (prev == null) {
                    root = null;
                } else if (prev.left != null && prev.left.item == key) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            } else if (curr.left == null && curr.right != null) { // one right child case
                if (prev == null) {
                    root = curr.right;
                } else {
                    prev.right = curr.right;
                }
            } else if (curr.right == null && curr.left != null) { // one left child case
                if (prev == null) {
                    root = curr.left;
                }
                prev.left = curr.left;
            } else { // two child case
                twoChildrenDelete(curr, prev);
            }
        }
    }

    /**
     * Deletes the Node that has two children.
     * 
     * @param curr The Node to delete.
     * @param prev The Node previous to the current Node.
     */
    private void twoChildrenDelete(Node curr, Node prev) {
        Node isCurr = curr.right;
        Node isPrev = curr;
        while (isCurr.left != null) {
            isPrev = isCurr;
            isCurr = isCurr.left;
        }
        if (curr == isPrev) { // just right of key inorder successor
            if (prev != null) {
                prev.left = isCurr;
            } else {
                root = isCurr;
            }
            isCurr.left = curr.left;
        } else { // right and left most of key inorder successor
            isPrev.left = isCurr.right;
            prev.left = isCurr;
            isCurr.left = curr.left;
            isCurr.right = curr.right;
        }
    }
    
    public boolean isValidBST(Node root) {
        return isValidHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean isValidHelper(Node root, long max, long min){
        boolean result;
        if(root == null ) result = true;

        else if(root.item >= max || root.item <= min) result = false;

        else result = isValidHelper(root.left, root.item, min) && isValidHelper(root.right, max, root.item);
        
        return result;
    }

    /**
     * Prints all the items in this Binary Tree in pre-order format.
     * 
     * @param curr The root of the Binary Tree.
     */
    public void preOrderPrint(Node curr) {
        if (curr != null) {
            System.out.println(curr.item);
            preOrderPrint(curr.left);
            preOrderPrint(curr.right);
        }
    }

    /**
     * Prints all the items in this Binary Tree in in-order format.
     * 
     * @param curr The root of the Binary Tree.
     */
    public void inOrderPrint(Node curr) {
        if (curr != null) {
            inOrderPrint(curr.left);
            System.out.println(curr.item);
            inOrderPrint(curr.right);
        }
    }

    /**
     * Prints all the items in this Binary Tree in post-order format.
     * 
     * @param curr The root of the Binary Tree.
     */
    public void postOrderPrint(Node curr) {
        if (curr != null) {
            postOrderPrint(curr.left);
            postOrderPrint(curr.right);
            System.out.println(curr.item);
        }
    }
}
