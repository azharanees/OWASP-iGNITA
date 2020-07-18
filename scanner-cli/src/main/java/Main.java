import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    String path;
    public static void main(String[] args) {
        Main scanner = new Main();

        switch( Math.min(args.length, 2)) {
            case 0:
                System.out.println("USAGE: Scanner path ");
                return;
            case 1: scanner.setPath(args[0]);
                return;
            default:
                System.out.println("USAGE: Scanner path ");
        }
        try {
            scanner.walkDirectory(scanner.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void walkDirectory(String path) throws IOException {
        Files.walk(Paths.get(path))
                .forEach(f -> analyzeFile(f.toFile()));
    }

    public void analyzeFile(File file) {
        try {
            if (executeTest(file)) {
                addToReport(file);
            }
        } catch (IOException| UncheckedIOException e) {
            System.out.println("Error processing file: " +
                    file + ": " + e);
        }
    }

    private void addToReport(File file) {
    }

    private boolean executeTest(File file) throws IOException{
        return false;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
