class Node {
    String english;
    String spanish;
    Node left, right;

    Node(String english, String spanish) {
        this.english = english;
        this.spanish = spanish;
        left = right = null;
    }
}
