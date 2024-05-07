import java.io.*;
import java.util.Scanner;

public class TSPNearestNeighbor {
    public static void main(String[] args) {
        File file = new File("file/path");
        String[] addresses = new String[100];
        int[][] distances = new int[100][100];
        boolean[] visited = new boolean[100];  // To track visited houses

        try {
            Scanner scan = new Scanner(file);
            for (int i = 0; i < 100; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                addresses[i] = parts[0];
                for (int j = 0; j < 100; j++) {
                    distances[i][j] = Integer.parseInt(parts[j + 1].trim());
                }
            }
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        // Implementing the Nearest Neighbor TSP
        int totalDistance = 0;
        int currentLocation = 0;  // Starting from Apache Pizza
        visited[currentLocation] = true;
        System.out.println("Route:");
        System.out.println(addresses[currentLocation]);

        for (int step = 0; step < 99; step++) {  // We need 99 more steps to visit all houses
            int nearest = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < 100; i++) {
                if (!visited[i] && distances[currentLocation][i] < minDistance) {
                    nearest = i;
                    minDistance = distances[currentLocation][i];
                }
            }
            visited[nearest] = true;
            totalDistance += minDistance;
            currentLocation = nearest;
            System.out.println(addresses[currentLocation]);
        }

        // Return to Apache Pizza
        totalDistance += distances[currentLocation][0];
        System.out.println("Return to Apache Pizza");
        System.out.println("Total Distance: " + totalDistance + " meters");
    }
}
