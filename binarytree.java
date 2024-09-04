public class binarytree {
    public static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BST {
        // Method to build the tree from an array of integers
        public node buildtree(int arr[]) {
            // Initialize the root with the first element of the array
            node root = new node(arr[0]);

            // Insert the rest of the elements into the tree
            for (int i = 1; i < arr.length; i++) {
                root = insert(arr[i], root);
            }
            return root;
        }

        // Method to insert a new value into the BST
        public node insert(int val, node root) {
            // If the current root is null, create a new node with the value
            if (root == null) {
                return new node(val);
            }

            //if node is not null and If the value is greater than the current node's data, insert into the right subtree
            if (val > root.data) {
                // Recursively insert the value in the right subtree and update root.right
                root.right = insert(val, root.right);
                // return root;
            } else {
                // Recursively insert the value in the left subtree and update root.left
                root.left = insert(val, root.left);
                // return root;
            }

            // Return the (possibly updated) root node
            return root;
        }
    }

    // Method to perform in-order traversal of the tree
    public static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 3, 1, 4, 6, 7};
        BST binaryTree = new BST();
        node root = binaryTree.buildtree(arr);

        inorder(root); // Expected output: 1 2 3 4 5 6 7
    }
}
