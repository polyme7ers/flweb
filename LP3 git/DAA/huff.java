//package lp3_daa;

import java.util.PriorityQueue;

// Node class for Huffman Tree
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

// Comparator for PriorityQueue (min-heap)
class CompareFreq implements java.util.Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
} 

public class huff {

    // Recursive function to print Huffman Codes
    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // If leaf node
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Function to build Huffman Tree
    static void buildHuffmanTree(char[] chars, int[] freq, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new CompareFreq());

        // Step 1: Create leaf nodes
        for (int i = 0; i < n; i++)
            pq.add(new Node(chars[i], freq[i]));

        // Step 2: Build the tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        // Step 3: Print Huffman Codes
        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters:");
        for (int i = 0; i < n; i++)
            chars[i] = sc.next().charAt(0);

        System.out.println("Enter their frequencies:");
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();

        buildHuffmanTree(chars, freq, n);

        sc.close();
    }
}
