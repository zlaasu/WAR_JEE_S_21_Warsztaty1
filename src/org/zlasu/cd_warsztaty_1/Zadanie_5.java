package org.zlasu.cd_warsztaty_1;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Zadanie_5 {

    private static final String URL = "http://www.onet.pl/";

    public static void main(String[] args) {
        Path path = Paths.get("./titles.txt");
        List<String> titleWords = searchAndParseTitleTagsInURL(URL);
        Map<String, Integer> countSameWords = countSameWords(titleWords);
        int max = findMaximumEepetition(countSameWords);
        sortWordsAndwriteToFile(max, path, countSameWords);

//        for (Map.Entry<String, Integer> entry : countSameWords.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

    }

    private static void sortWordsAndwriteToFile(int max, Path path, Map<String, Integer> countSameWords) {
        List<String> outList = new ArrayList<>();

        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : countSameWords.entrySet()) {
                if (entry.getValue() == i) {
                    outList.add(entry.getValue() + " - " + entry.getKey());
                }
            }
        }

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.err.println("Błąd tworzenia pliku.");
                return;
            }
        }

        try {
            Files.write(path, outList);
        } catch (IOException e) {
            System.err.println("Błąd zapisywania pliku.");
            return;
        }
    }

    private static int findMaximumEepetition(Map<String, Integer> countSameWords) {
        int max = 0;

        for (Map.Entry<String, Integer> entry : countSameWords.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        return max;
    }

    private static Map<String, Integer> countSameWords(List<String> titleWords) {
        Map<String, Integer> duplicates = new HashMap<String, Integer>();

        for (String str : titleWords) {
            if (duplicates.containsKey(str)) {
                duplicates.put(str, duplicates.get(str) + 1);
            } else {
                duplicates.put(str, 1);
            }
        }

        return duplicates;
    }

    private static List<String> searchAndParseTitleTagsInURL(String url) {
        List<String> lines = new ArrayList<>();
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        StringTokenizer tokenizer;

        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                tokenizer = new StringTokenizer(elem.text(), " .,;:!?\"„[](){}”");
                while (tokenizer.hasMoreElements()) {
                    String word = tokenizer.nextToken().toLowerCase();
                    if (word.length() > 3) {
                        lines.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
