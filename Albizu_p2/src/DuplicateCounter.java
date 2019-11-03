import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public DuplicateCounter() {
        wordCounter = new HashMap<String, Integer>();
    }

    public void count(String datafile) {
        Scanner inputfile = null;
        try {
            inputfile = new Scanner(new File(datafile));
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
            return;
        }
        inputfile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+");
        while (inputfile.hasNext()) {
            String word = inputfile.next().toLowerCase();
            Integer count = wordCounter.get(word);
            if (count == null)
                count = 1;
            else
                count = count + 1;
            wordCounter.put(word, count);
        }
        inputfile.close();
    }


    public void write(String datafile){

        try {
            PrintWriter outputfile = new PrintWriter(new File(datafile));
            for(String k : wordCounter.keySet()) {
                outputfile.println(k + " " + wordCounter.get(k));
            }
            outputfile.close();

        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

}