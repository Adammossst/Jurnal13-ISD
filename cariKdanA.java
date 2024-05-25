public class cariKdanA {
    Node root;

    static class Node {
        char key;
        Node left, right;

        Node(char item) {
            key = item;
            left = right = null;
        }
    }

    // Insert a node into the BST
    Node insert(Node node, char key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    // Search for a node in the BST
    Node search(Node node, char key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Inorder traversal of the BST
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        cariKdanA tree = new cariKdanA();

        tree.root = tree.insert(tree.root, 'F');
        tree.insert(tree.root, 'E');
        tree.insert(tree.root, 'H');
        tree.insert(tree.root, 'D');
        tree.insert(tree.root, 'G');
        tree.insert(tree.root, 'C');
        tree.insert(tree.root, 'B');
        tree.insert(tree.root, 'H');
        tree.insert(tree.root, 'K');
        tree.insert(tree.root, 'J');

        System.out.println("Inorder traversal of the BST:");
        tree.inorder(tree.root);

        Node found = tree.search(tree.root, 'K');
        if (found != null) {
            System.out.println("K found in the BST");
        } else {
            System.out.println("K not found in the BST");
        }

        found = tree.search(tree.root, 'A');
        if (found != null) {
            System.out.println("A found in the BST");
        } else {
            System.out.println("A not found in the BST");
        }
    }
}