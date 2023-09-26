import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /*Задание: Найди все слова в тексте, которые встречаются чаще, чем N раз*/
        while (true) {
            Integer input = Scanner.scanner();
            String text = "один, два, два, три, три, три, четыре, четыре, четыре, четыре, пять, пять, пять, пять, пять";
            String[] textSplit = text.split(", ");
            HashMap<String, Integer> result = new HashMap<>();
            searchWords(input, textSplit, result);
        }
    }

    public static void searchWords(Integer input, String[] textSplit, HashMap<String, Integer> result) {
        int countMax = 0;
        for (int i = 0; i < textSplit.length; i++) {
            int count = 0;
            for (int j = 0; j < textSplit.length; j++) {
                if (textSplit[i].equals(textSplit[j])) {
                    count++;
                    if (countMax < count) {
                        countMax = count;
                    }
                }
            }
            if (count >= input) {
                result.put("Слово:" + textSplit[i] + " кол.повторов: ", count);
            }
        }
        if (countMax < input) {
            System.out.println("Данное количество повторов отсутствует");
        } else {
            System.out.println(result);
        }
    }
}