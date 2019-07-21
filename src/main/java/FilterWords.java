import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class FilterWords {

    private FileReader fr;
    private int count1;
    private Map<String, Integer> songWordMap;
    private List<String> ignored;

    FilterWords(String fileName) throws FileNotFoundException {

        fr = new FileReader(fileName);
        songWordMap = new TreeMap<>();
        ignored = new ArrayList<>();
    }

    int calculateCount() throws IOException {
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int count = 0;
        while (line != null) {
            String[] parts = line.split("[\\p{Punct}\\p{Space}]+");
            for (String word : parts) {
                count++;
                if (word.length() < 3) {
                    ignored.add(word);
                    count1++;
                } else if (songWordMap.containsKey(word)) {
                    songWordMap.replace(word, count);
                } else {
                    songWordMap.put(word, 1);
                }
            }

            line = br.readLine();
        }
        return count;
    }

    void findWords() {
        List<String> commonWord = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : songWordMap.entrySet()) {
            if (pair.getValue() > 3) {
                commonWord.add(pair.getKey());
            }
        }
        System.out.println("Most often found: " + commonWord);
    }

    public int getCount1() {
        return count1;
    }

    public List<String> getIgnored() {
        return ignored;
    }
}



