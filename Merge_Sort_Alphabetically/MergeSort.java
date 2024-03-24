public class MergeSort {
    public static void main(String[] args) {
        String word1 = "abcdhij";
        String word2 = "efg";
        String merged = sortMergeStrings(word1, word2);
        System.out.println(merged);
    }
    public static String sortMergeStrings(String word1, String word2) {
        int i = 0;
        int j = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder sb = new StringBuilder();
        while (i < n1 && j < n2) {
            if(word1.charAt(i) < word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        return i < n1 ? sb.append(word1.substring(i)).toString() :
                sb.append(word2.substring(j)).toString();
    }
}
