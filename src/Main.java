import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /*Задание: Найди все слова в тексте, которые встречаются чаще, чем N раз*/
        while (true) {
            // Scanner.scanner(); method name is not pretty, it should be like "nextInt" or something.
            // Also you like static methods too much, it's better to start designing your app as a component (see below).
            Integer input = Scanner.scanner();
            String text = "один, два, два, три, три, три, четыре, четыре, четыре, четыре, пять, пять, пять, пять, пять";
            // No comma needed, usually text doesn't have comma after each word.
            String[] textSplit = text.split(", ");
            // Why is hashmap created there? It's only used inside method, so should be created inside of it
            // Also HashMap is a concrete type, in type definitions it's better to use interfaces:
            // Map<String, Integer> result = new HashMap<>();
            HashMap<String, Integer> result = new HashMap<>();
            searchWords(input, textSplit, result);
        }
    }

    // Better to implement it like this
    // public static Map<String, Integer> countWords(Integer repeats, String text)
    public static void searchWords(Integer input, String[] textSplit, HashMap<String, Integer> result) {
        int countMax = 0;
        for (int i = 0; i < textSplit.length; i++) {
            // This one can be optimized the way the same word will not be searched inside of the array for several times
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
                // Just result.put(textSplit[i], count);, no need additional stuff.
                // If you wand to add some additional working when printing the result then do it when you print
                // otherwise you're just spoiling the data there and make in unusable anywhere else but console logs.
                result.put("Слово:" + textSplit[i] + " кол.повторов: ", count);
            }
        }
        // Better make the method to return Map and print its content outside of the method
        // You don't need countMax, you can just use result.isEmpty()
        if (countMax < input) {
            System.out.println("Данное количество повторов отсутствует");
        } else {
            System.out.println(result);
        }
    }
}

// Design your tack as a component:
/*
public class TextUtils {
    public TextUtils() {}

    // Yes, I know Java likes to use static methods, but lots of static methods are not really compatible with SOLID.
    // So better not to get used to use static methods everywhere, and develop component-based thinking.
    // Each of our tasks is something that can be used as an algo withing some other application, so you need to develop
    // a solution as something that can be used in a convenient way by other developer.

    public Map<String, Integer> countWords(Integer repeats, String text) {
        ...
    }
}
 */

// Architectural approach:
/*
public interface TextUtils {
    public Map<String, Integer> countWords(Integer repeats, String text);
}

public class DefaultTextUtils: TextUtils {
    public Map<String, Integer> countWords(Integer repeats, String text) {
        ...
    }
 }

 public class Main {
    public static void main(String[] args) {
    // Yep, there may even be a factory, but let's just construct it just like this.
        String text = "...";
        Integer repeats = Scanner.scanner();
        TextUtils utils = DefaultTextUtils()
        Map<String, Integer> result = utils.countWords(...);
        if (result.isEmpty()) {
            ...
        } else {
            ... // Iterate over the map and print each pair formatted as you want it.
        }
    }
}

 */