
// S.Mohanaranjan
// 20200607

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//task 3
public class parser {
    private Map<Integer, List<Integer>> ReadGraph;

    public parser() {
        this.ReadGraph = new HashMap<>();
    }

    public void parseGraphFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            if (!ReadGraph.containsKey(source)) {
                ReadGraph.put(source, new ArrayList<>());
            }
            ReadGraph.get(source).add(destination);
        }
    }

    public Map<Integer, List<Integer>> getGraph() {
        return ReadGraph;
    }

    public static void main(String[] args) {
        parser parser = new parser();
        try {
            parser.parseGraphFromFile("/Users/shanmugaratnammohanaranjan/Desktop/Test_20200607/Text.txt");
            Map<Integer, List<Integer>> graph = parser.getGraph();
            System.out.println("Parsed graph: " + graph);
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find input file.");
        }
    }
}
