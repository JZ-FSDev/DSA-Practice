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
    }

    private Node root;

    public BinaryTree(){
        root = null;
    }

    public void insert(int item){
        if(root == null){
            root = new Node(item);
        }else{
            Node node = new Node(item);
            Node curr = root;
            Node prev = root;
            while(curr != null){
                if(item < curr.item){
                    prev = curr;
                    curr = curr.left;
                }else{
                    prev = curr;
                    curr = curr.right;
                }
            }
            if(item > prev.item){
                prev.right = node;
            }else{
                prev.left = node;
            }
        }
    }
    
    public boolean search(int key){
        Node curr = root;
        boolean found = false;
        while(curr != null && !found){
            if(key == curr.item){
                found = true;
            }else if(key > curr.item){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return found;
    }    
  
    public boolean searchRecursive(Node curr, int key){
        boolean found = (key == curr.item);
        if((curr.left != null || curr.right != null) && !found){
            if(key > curr.item){
                found = searchRecursive(curr.right, key);
            }else{
                found = searchRecursive(curr.left, key);
            }
        }
        return found;
    }
    
    public void insertRecursive(Node prev, Node curr, int item){
        if(curr != null){
            if(item < curr.item){
                insertRecursive(curr, curr.left, item);
            }else{
                insertRecursive(curr, curr.right, item);
            }
        }else{
            if(root == null){
                root = new Node(item);
            }else{
                Node node = new Node(item);
                if(item > prev.item){
                    prev.right = node;
                }else{
                    prev.left = node;
                }
            }
        }
    }
    
    public void delete(int key){
        Node prev = null;
        Node curr = root;
        boolean found = false;
        while(curr != null && !found){
            if(key == curr.item){
                found = true;
            }else if(key > curr.item){
                prev = curr;
                curr = curr.right;
            }else{
                prev = curr;
                curr = curr.left;
            }
        }
        if(found){
            if(curr.left == null && curr.right == null){ // leaf case
                if(prev == null){
                    root = null; 
                }else if(prev.left != null && prev.left.item == key){
                    prev.left = null;
                }else{
                    prev.right = null;
                }
            }else if(curr.left == null && curr.right != null){ // one right child case
                if(prev == null){
                    root = curr.right;
                }else{
                    prev.right = curr.right;
                }
            }else if(curr.right == null && curr.left != null){ // one left child case
                if(prev == null){
                    root = curr.left;
                }
                prev.left = curr.left;
            }else{ // two child case
                twoChildrenDelete(curr, prev);
            }
        }
    }
    
    private void twoChildrenDelete(Node curr, Node prev){
        Node isCurr = curr.right;
        Node isPrev = curr;
        while(isCurr.left != null){
            isPrev = isCurr;
            isCurr = isCurr.left;
        }
        if(curr == isPrev){ // just right of key inorder successor
            if(prev != null){
                prev.left = isCurr;
            }else{
                root = isCurr;
            }
            isCurr.left = curr.left;
        }else{ // right and left most of key inorder successor
            isPrev.left = isCurr.right;
            prev.left = isCurr;
            isCurr.left = curr.left;
            isCurr.right = curr.right;
        }
    }    
}
