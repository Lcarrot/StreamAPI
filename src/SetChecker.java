import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SetChecker {

    public static boolean hasThreeVowel(String element) {
        int count = 0;
        Character[] vowels = new Character[]{'A', 'a', 'e', 'E', 'y', 'Y', 'u','U','o','O',};
        for (int i = 0; i < element.length(); i++) {
            for (Character character: vowels) {
                if(element.charAt(i) == character) {
                    count++;
                    break;
                }
            }
            if (count > 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> words = new LinkedHashSet<>();
        words.add("Obeema");
        words.add("Goa");
        words.add("fukuoka");
        Stream<String> stream = words.stream();
        int l = (int)stream.filter(SetChecker::hasThreeVowel).count();
        System.out.println(l);
        System.out.println("-------------------------------------------------------------------");
        Collection<String> collection = new LinkedList<>();
        collection.add("mama");
        collection.add("sestrica");
        collection.add("brat2");
        collection.add("maximilian");
        Stream<String> stream1 = collection.stream();
        int k = stream1.filter(s -> s.length() > 5).mapToInt(String::length).sum();
        System.out.println(k);
    }
}

