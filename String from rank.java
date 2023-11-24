import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int R = scanner.nextInt();
        scanner.nextLine();
        String[] strings = scanner.nextLine().split(",");
        List< List< String>> subsets = generateSubsets(strings);
        if (R <= subsets.size()) {
            List< String> result = subsets.get(R - 1);
            System.out.println(String.join(",", result));
        } else {
            System.out.println("Rank exceeds the number of subsets.");
        }
    }
    public static List<  List> generateSubsets(String[] strings) {
        List< List< String>> subsets = new ArrayList<>();
        int n = strings.length;
        subsets.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            subsets.add(Collections.singletonList(strings[i]));
        }
        for (int subsetSize = 2; subsetSize <= n; subsetSize++) {
            List< List< String>> combinations = getCombinations(strings, subsetSize);
            for (List< String> combination : combinations) {
                boolean validCombination = true;
                for (int i = 0; i < combination.size() - 1; i++) {
                    if (Arrays.asList(strings).indexOf(combination.get(i)) > Arrays.asList(strings).indexOf(combination.get(i + 1))) {
                        validCombination = false;
                        break;
                    }
                }
                if (validCombination) {
                    subsets.add(new ArrayList<>(combination));
                }
            }
        }
        return subsets;
    }
    public static List< List> getCombinations(String[] strings, int subsetSize) {
        List< List> combinations = new ArrayList<>();
        generateCombinations(strings, subsetSize, 0, new ArrayList<>(), combinations);
        return combinations;
    }
    public static void generateCombinations(String[] strings, int subsetSize, int index, List< String> currentCombination, List< List> combinations) {
        if (subsetSize == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        if (index >= strings.length) {
            return;
        }
        currentCombination.add(strings[index]);
        generateCombinations(strings, subsetSize - 1, index + 1, currentCombination, combinations);
        currentCombination.remove(currentCombination.size() - 1);
        generateCombinations(strings, subsetSize, index + 1, currentCombination, combinations);
    }
}
