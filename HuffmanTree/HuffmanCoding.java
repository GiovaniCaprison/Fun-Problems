import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class HuffmanCoding {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();
 
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : sentence.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
 
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.printf("'%c' has a frequency of %d%n", entry.getKey(), entry.getValue());
        }
    }
}
