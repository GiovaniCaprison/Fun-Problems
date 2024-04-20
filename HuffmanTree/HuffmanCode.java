import java.util.Map;
import java.util.HashMap;
 
public class HuffmanCode {
    private static void printCodes(Node root, String str) {
        if (root == null) {
            return;
        }
        if (root.leftChild == null && root.rightChild == null && Character.isDefined(root.character)) {
            System.out.println("'" + root.character + "' : " + str);
        }
        printCodes(root.leftChild, str + "0");
        printCodes(root.rightChild, str + "1");
    }
 
    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        HuffmanCoding.main(null);  
        Node root = huffmanTree.buildTree(frequencyMap);
        printCodes(root, "");
    }
}
