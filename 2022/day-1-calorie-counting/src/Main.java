import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        try {
        numbers = Files.readAllLines(Paths.get("input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }

//        first task
//        int result = 0;
//        int caloriesOfCurrentElf = 0;
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i).equals("") || i == numbers.size() - 1) {
//                if (caloriesOfCurrentElf > result) {
//                    result = caloriesOfCurrentElf;
//                }
//                caloriesOfCurrentElf = 0;
//            } else {
//                caloriesOfCurrentElf += Integer.valueOf(numbers.get(i));
//            }
//        }
//        System.out.println(result);

//        second part
        List<Integer> sums = new ArrayList<>();
        int caloriesOfCurrentElf = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals("") || i == numbers.size() - 1) {
                sums.add(caloriesOfCurrentElf);
                caloriesOfCurrentElf = 0;
            } else {
                caloriesOfCurrentElf += Integer.valueOf(numbers.get(i));
            }
        }

        Collections.sort(sums, Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += sums.get(i);
        }
        System.out.println(result);
    }
}