import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // read all lines from input file
        List<String> lines = getLines("input.txt");

        // get height of highest stack
        int maxHeightOfStacks = 0;
        while(!isNumeric(lines.get(maxHeightOfStacks).substring(1,2))) {
            maxHeightOfStacks++;
        }

        // get count of stacks
        String[] stackNumbers = lines.get(maxHeightOfStacks).split(" ");
        int countOfStacks = Integer.valueOf(stackNumbers[stackNumbers.length - 1]);

        // create array of stacks
        Stack<String>[] stacks = new Stack[countOfStacks];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        // fill stacks
        for (int i = maxHeightOfStacks - 1; i >= 0 ; i--) {
            for (int j = 0; j < countOfStacks; j++) {
                int currentCrateCharacterPosition = 1 + j * 4;
                if (lines.get(i).length() >= currentCrateCharacterPosition + 1 && lines.get(i).charAt(currentCrateCharacterPosition) != ' ') {
                    stacks[j].push(lines.get(i).substring(currentCrateCharacterPosition,currentCrateCharacterPosition + 1));
                }
            }
        }

        // iterate over instructions
        Stack<String> temporaryStack = new Stack<>();
        for (int i = maxHeightOfStacks + 2; i < lines.size(); i++) {
            String[] words = lines.get(i).split(" ");
            int repetitions = Integer.parseInt(words[1]);
            int sourceStackNumber = Integer.parseInt(words[3]) - 1;
            int destinationStackNumber = Integer.parseInt(words[5]) - 1;
            if (false) {
                for (int j = 0; j < repetitions; j++) {
                    stacks[destinationStackNumber].push(stacks[sourceStackNumber].pop());
                }
            } else {
                for (int j = 0; j < repetitions; j++) {
                    temporaryStack.push(stacks[sourceStackNumber].pop());
                }
                for (int j = 0; j < repetitions; j++) {
                    stacks[destinationStackNumber].push(temporaryStack.pop());
                }
            }
        }

        // print result
        for (int i = 0; i < stacks.length; i++) {
            System.out.print(stacks[i].pop());
        }
    }

    public static List<String> getLines(String filepath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filepath));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return lines;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}