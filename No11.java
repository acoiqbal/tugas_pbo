import java.util.ArrayList;
import java.util.List;

// Class Node
class Node {
    double value;
    List<Node> children;

    public Node(double value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }

    public double getValue() {
        return value;
    }
}

// Class Tree
class Tree {
    private Node root;

    public Tree(double rootValue) {
        root = new Node(rootValue);
    }

    // Method menambahkan node ke root sebagai child baru
    public void addChildNode(Node node) {
        root.addChild(node);
    }

    // Mencari nilai tertentu di seluruh tree, rekursif dari root
    public boolean search(double value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node current, double value) {
        if (current == null) return false;
        if (current.getValue() == value) return true;

        for (Node child : current.getChildren()) {
            if (searchRecursive(child, value)) {
                return true;
            }
        }
        return false;
    }

    // Konversi tree menjadi string dengan traversal preorder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRecursive(root, sb, 0);
        return sb.toString();
    }

    private void toStringRecursive(Node node, StringBuilder sb, int depth) {
        if (node == null) return;

        // Indentasi sesuai level depth untuk representasi visual
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }

        sb.append(node.getValue()).append("\n");

        for (Node child : node.getChildren()) {
            toStringRecursive(child, sb, depth + 1);
        }
    }
}

// Class Main untuk simulasi penggunaan
public class No11 {
    public static void main(String[] args) {
        // Membuat tree dengan root nilai 10
        Tree tree = new Tree(10);

        // Membuat beberapa node anak
        Node node1 = new Node(5);
        Node node2 = new Node(15);
        Node node3 = new Node(3);
        Node node4 = new Node(7);

        // Menambahkan node anak ke root
        tree.addChildNode(node1);
        tree.addChildNode(node2);

        // Menambahkan node anak ke node1
        node1.addChild(node3);
        node1.addChild(node4);

        // Cetak seluruh isi tree
        System.out.println("Isi tree:");
        System.out.println(tree);

        // Cari nilai tertentu di tree
        double cari1 = 7;
        double cari2 = 20;
        System.out.println("Mencari nilai " + cari1 + ": " + (tree.search(cari1) ? "Ditemukan" : "Tidak ditemukan"));
        System.out.println("Mencari nilai " + cari2 + ": " + (tree.search(cari2) ? "Ditemukan" : "Tidak ditemukan"));
    }
}
