import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the vertex to start at: ");
        String start = scan.nextLine();
        
        Map<String, List<String>> graph = readGraph();

        Map<String, Integer> shortestPaths = bfs(graph, start);

        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("Distance from " + start + " to " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, List<String>> readGraph() throws FileNotFoundException {
        Map<String, List<String>> graph = new HashMap<>();
        Scanner scanner = new Scanner(new File("file/path"));
        int index = 0;
        while (scanner.hasNextLine()) {
            String[] edges = scanner.nextLine().split(",");
            String node = edges[0];
            graph.put(node, new ArrayList<>());
            for (int i = 1; i < edges.length; i++) {
                if (edges[i].equals("1")) {
                    graph.get(node).add(Character.toString((char) (65 + i - 1))); 
                }
            }
            index++;
        }
        return graph;
    }

    private static Map<String, Integer> bfs(Map<String, List<String>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            List<String> neighbors = graph.get(node);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        distances.put(neighbor, distances.get(node) + 1);
                    }
                }
            }
        }
        return distances;
    }
}
