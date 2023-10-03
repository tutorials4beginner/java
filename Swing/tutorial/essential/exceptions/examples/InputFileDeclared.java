import java.io.*;

public class InputFileDeclared {

    private FileReader in;

    public InputFileDeclared(String filename) throws FileNotFoundException {
        in = new FileReader(filename);
    }

    public String getWord() throws IOException {
        int c;
        StringBuffer buf = new StringBuffer();

        do {
            c = in.read();
            if (Character.isWhitespace((char)c))
                return buf.toString();
            else
                buf.append((char)c);
        } while (c != -1);

        return buf.toString();
    }
}
