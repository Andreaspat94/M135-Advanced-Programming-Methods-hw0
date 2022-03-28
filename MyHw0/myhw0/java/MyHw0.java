import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class MyHw0 {
    public static void main(String[] args) {
        LinkedHashMap<String, TreeSet<Integer>> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String current_line;
        while (scanner.hasNextLine()) {

            current_line = scanner.nextLine();
            if (current_line.isBlank() || current_line.isEmpty()) {
                break;
            }
            String[] split_outcome = current_line.split("\\|");
            String key = split_outcome[0];
            Integer value = Integer.valueOf(split_outcome[1]);

            if (map.keySet().contains(key)) {
                map.get(split_outcome[0]).add(value);
            } else {
                TreeSet<Integer> valueSet = new TreeSet<Integer>();
                valueSet.add(value);
                map.put(key, valueSet);
            }
        }

        Map<String, String> outputMap = new LinkedHashMap<>();
        map.forEach((k, v) -> outputMap.put(k, String.valueOf((long) v.size())));
        for (var entry : outputMap.entrySet()) {
            System.out.println(entry.getKey() + "|" + entry.getValue());
        }

        scanner.close();
    }
}
