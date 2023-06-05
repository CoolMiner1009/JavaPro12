import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Приклади виклику методів
        List<String> words = new ArrayList<>();
        words.add("bird");
        words.add("cat");
        words.add("bird");
        words.add("dog");
        words.add("cat");

        String targetWord = "bird";
        int occurrenceCount = countOccurrence(words, targetWord);
        System.out.println("Кількість входжень слова \"" + targetWord + "\": " + occurrenceCount);

        int[] array = {1, 2, 3};
        List<Integer> list = toList(array);
        System.out.println("Список: " + list);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        List<Integer> uniqueNumbers = findUnique(numbers);
        System.out.println("Унікальні числа: " + uniqueNumbers);

        List<String> wordList = new ArrayList<>();
        wordList.add("bird");
        wordList.add("cat");
        wordList.add("bird");
        wordList.add("dog");
        wordList.add("cat");
        calcOccurrence(wordList);

        List<WordOccurrence> occurrences = findOccurrence(wordList);
        System.out.println("Входження слів: " + occurrences);
    }

    public static int countOccurrence(List<String> words, String targetWord) {
        int count = 0;
        for (String word : words) {
            if (word.equals(targetWord)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        return uniqueNumbers;
    }

    public static void calcOccurrence(List<String> words) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : words) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<WordOccurrence> findOccurrence(List<String> words) {
        List<WordOccurrence> occurrences = new ArrayList<>();
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : words) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            WordOccurrence occurrence = new WordOccurrence(entry.getKey(), entry.getValue());
            occurrences.add(occurrence);
        }
        return occurrences;
    }

    static class WordOccurrence {
        private String name;
        private int occurrence;

        public WordOccurrence(String name, int occurrence) {
            this.name = name;
            this.occurrence = occurrence;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOccurrence() {
            return occurrence;
        }

        public void setOccurrence(int occurrence) {
            this.occurrence = occurrence;
        }

        @Override
        public String toString() {
            return "{name: \"" + name + "\", occurrence: " + occurrence + "}";
        }
    }
}
