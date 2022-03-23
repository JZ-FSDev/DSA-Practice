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
}
