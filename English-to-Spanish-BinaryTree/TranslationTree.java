import java.util.LinkedList;
import java.util.Queue;

class TranslationTree {
    Node root;
    int stepsTaken;
    void insert(String english, String spanish) {
        root = insertRecursive(root, english, spanish);
    }

    Node insertRecursive(Node root, String english, String spanish) {
        if (root == null) {
            root = new Node(english, spanish);
            return root;
        }

        if (english.compareTo(root.english) < 0)
            root.left = insertRecursive(root.left, english, spanish);
        else if (english.compareTo(root.english) > 0)
            root.right = insertRecursive(root.right, english, spanish);

        return root;
    }

    String translate(String englishText) {
        StringBuilder spanishText = new StringBuilder();
        String[] words = englishText.split(" ");
        stepsTaken = 0;

        for (String word : words) {
            String spanish = translateWord(root, word);
            spanishText.append(spanish).append(" ");
        }
        System.out.println("Steps taken: " + stepsTaken);
        return spanishText.toString().trim();
    }

    String translateWord(Node root, String english) {
        Node current = root;
        while (current != null) {
            stepsTaken++;
            if (english.equals(current.english))
                return current.spanish;
            else if (english.compareTo(current.english) < 0)
                current = current.left;
            else
                current = current.right;
        }
        return english; // return the original word if not found in the tree
    }

    int getHeight() {
        return getHeight(root);
    }
    private int getHeight(Node root) {
        if (root == null)
            return 0;

        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // Marker to separate levels

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null); // Add marker for next level
                    height++;
                }
            } else {
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }

        return height;
    }
}
