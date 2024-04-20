import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TranslationProgram {
    public static void main(String[] args) {
        TranslationTree tree = new TranslationTree();
        loadTranslations(tree, "EnglishSpanish.csv");
        int height = tree.getHeight();

        System.out.println("Enter ecs to exit.");
        System.out.println("Height of the tree: " + height);

        startTranslation(tree);
    }
    static void loadTranslations(TranslationTree tree, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String english = parts[0];
                String spanish = parts[1];
                tree.insert(english, spanish);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void startTranslation(TranslationTree tree) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter English text to translate to Spanish: ");
            String englishText = scanner.nextLine();
            if ("esc".equalsIgnoreCase(englishText)) {
                System.out.println("Exiting program...");
                scanner.close();
                System.exit(0);
            }
            String spanishText = tree.translate(englishText);
            System.out.println("Spanish translation: " + spanishText);
        }
    }
}