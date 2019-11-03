public class Application {
    public static void main(String[] args) {
        String inputFilename = "problem2.txt";
        String outputFilename = "unique_word_counts.txt";
        DuplicateCounter dc = new DuplicateCounter();
        dc.count(inputFilename);
        dc.write(outputFilename);
    }
}