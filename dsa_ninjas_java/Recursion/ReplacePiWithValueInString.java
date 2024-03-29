import java.util.Arrays;

public class ReplacePiWithValueInString {
    public static String replace(String source, int currentIndex) {
        // requires 1 less argument to be passed while calling
        if (currentIndex >= source.length()) {
            return "";
        } else if (source.startsWith("pi", currentIndex)) {
            return "3.14" + replace(source, currentIndex + 2);
        }
        return source.charAt(currentIndex) + replace(source, currentIndex + 1);
    }

    public static String replace(String source, String result, int currentIndex) {
        if (currentIndex >= source.length()) {
            return result;
        } else if (source.charAt(currentIndex) == 'p' && currentIndex != source.length() - 1
                && source.charAt(currentIndex + 1) == 'i') {
            return replace(source, result + "3.14", currentIndex + 2);
        }
        return replace(source, result + source.charAt(currentIndex), currentIndex + 1);
    }

    public static String replacev1(String source) {
        return replace(source, "", 0);
    }

    public static String replacev2(String source) {
        return replace(source, 0);
    }

    public static void main(String[] args) {
        String[] testValues = { "The value of PI is pi", "Hellopi!!!", "Thelifeof pi", "Thelifeof pi ", "pi rocks",
                "pi", "    pi", "popipopipi", "ipipipipip" };
        Arrays.stream(testValues).forEach(s -> System.out.println(replacev1(s)));
        Arrays.stream(testValues).forEach(s -> System.out.println(replacev2(s)));
    }
}
