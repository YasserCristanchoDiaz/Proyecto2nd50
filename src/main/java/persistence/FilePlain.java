package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilePlain {
    private Path path;
    private String pathFile;
    private String nameFile;

    public FilePlain(String pathFile, String nameFile) {
        this.pathFile = pathFile;
        this.nameFile = nameFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void openFile() {
        path = Paths.get(pathFile + nameFile);
    }

    public String readFile() throws IOException {
        BufferedReader input = Files.newBufferedReader(path, Charset.defaultCharset());
        StringBuilder output = new StringBuilder();
        String line = null;
        while ( (line = input.readLine()) != null ) {
            output.append(line + "\n");
        }
        input.close();
        return output.toString();
    }

    public void writerFile(String data) throws IOException {
        BufferedWriter output = Files.newBufferedWriter(path, Charset.defaultCharset(),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        output.write( data );
        output.close();
    }


}
