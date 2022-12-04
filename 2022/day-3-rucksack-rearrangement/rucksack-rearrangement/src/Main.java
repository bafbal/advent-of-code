import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> rucksacks = new ArrayList<>();
        try {
            rucksacks = Files.readAllLines(Paths.get("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }

        int totalPoints = 0;

//        part one
        StringBuilder charactersInActualRuckSackToBeRepacked = new StringBuilder();
        for (String rucksack : rucksacks) {
            for (int j = 0; j < rucksack.length() / 2; j++) {
                for (int k = rucksack.length() / 2; k < rucksack.length(); k++) {
                    if (rucksack.charAt(j) == rucksack.charAt(k) && charactersInActualRuckSackToBeRepacked.indexOf(String.valueOf(rucksack.charAt(j))) == -1) {
                        charactersInActualRuckSackToBeRepacked.append(rucksack.charAt(j));
                    }
                }
            }
            for (int j = 0; j < charactersInActualRuckSackToBeRepacked.length(); j++) {
                totalPoints += getValueOfChar(charactersInActualRuckSackToBeRepacked.charAt(j));
            }
            charactersInActualRuckSackToBeRepacked.setLength(0);
        }

////        part two
//        StringBuilder characterOfActualBadge = new StringBuilder();
//        for (int i = 0; i < rucksacks.size(); i += 3) {
//            for (int j = 0; j < rucksacks.get(i).length(); j++) {
//                if (rucksacks.get(i + 1).indexOf(rucksacks.get(i).charAt(j)) != -1 && rucksacks.get(i + 2).indexOf(rucksacks.get(i).charAt(j)) != -1 && characterOfActualBadge.indexOf(String.valueOf(rucksacks.get(i).charAt(j))) == -1) {
//                    totalPoints += getValueOfChar(rucksacks.get(i).charAt(j));
//                    characterOfActualBadge.append(rucksacks.get(i).charAt(j));
//                }
//            }
//            characterOfActualBadge.setLength(0);
//        }
        System.out.println(totalPoints);
    }

    public static int getValueOfChar(char character) {
        return Character.toLowerCase(character) == character ? character - 96 : character - 38;
    }
}