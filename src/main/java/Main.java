import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilterWords filterWords = new FilterWords("src/main/resources/data.txt");
        System.out.println("The total number of words in the text: " + filterWords.calculateCount());
        System.out.println("The number of words is less than three characters: " + filterWords.getCount1());
        System.out.println(filterWords.getIgnored());
        filterWords.findWords();
    }
}
