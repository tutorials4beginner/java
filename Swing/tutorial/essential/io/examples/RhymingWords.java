import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;


public class RhymingWords {
    public static void main(String[] args) throws IOException {

        FileReader words = new FileReader("words.txt");

        // do the reversing and sorting
        Reader rhymedWords = reverse(sort(reverse(words)));

        // write new list to standard out
        BufferedReader in = new BufferedReader(rhymedWords);
        String input;

        while ((input = in.readLine()) != null)
            System.out.println(input);
        in.close();
    }

    public static Reader reverse(Reader source) throws IOException {

        BufferedReader in = new BufferedReader(source);

        PipedWriter pipeOut = new PipedWriter();
        PipedReader pipeIn = new PipedReader(pipeOut);
        PrintWriter out = new PrintWriter(pipeOut);

        new ReverseThread(out, in).start();

        return pipeIn;
    }

    public static Reader sort(Reader source) throws IOException {

        BufferedReader in = new BufferedReader(source);

        PipedWriter pipeOut = new PipedWriter();
        PipedReader pipeIn = new PipedReader(pipeOut);
        PrintWriter out = new PrintWriter(pipeOut);

        new SortThread(out, in).start();

        return pipeIn;
    }
}
