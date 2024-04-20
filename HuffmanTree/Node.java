import java.util.PriorityQueue;
 
class Node {
    char character;
    int frequency;
    Node leftChild, rightChild;
 
    Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.leftChild = null;
        this.rightChild = null;
    }
 
    Node(Node leftChild, Node rightChild) {
        this.frequency = leftChild.frequency + rightChild.frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
