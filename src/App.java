import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 * Functionality: Simple Program to MoveFiles to new subfolders
 * By: Henry Patrick Karugendo
 * Date: 4th June 2021
 */
public class App {
    private final File folder = new File("F:/CAPS");

    public App() {
    }

    public void work() {
        int fileCounter = 0;
        int folderNum = 1;
        try {
            for (final File aFile : folder.listFiles()) {
                File aFolder = new File("F:/CAPS/" + folderNum);
                if (!aFolder.exists()) {
                    aFolder.mkdir();
                }
                if (!aFile.isDirectory()) {
                    if (fileCounter < 4001) {
                        Files.move(Paths.get("F:/CAPS/" + aFile.getName()), Paths.get("F:/CAPS/" + folderNum + "/" + aFile.getName()), StandardCopyOption.REPLACE_EXISTING);
                        fileCounter++;
                    }
                }
                if (fileCounter == 4001) {
                    System.out.println("Moved 4000 files");
                    fileCounter = 0;
                    folderNum++;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR READING FILES!");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.work();
    }
}
