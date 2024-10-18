import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApiKeyManager {
    private String apiKey;

    public ApiKeyManager() {
        try {
            File file = new File("apikey.txt");
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                this.apiKey = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo de API key no encontrado.");
            e.printStackTrace();
        }
    }

    public String getApiKey() {
        return apiKey;
    }
}
