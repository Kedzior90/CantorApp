import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;

public class CantorConsole {
    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();
    public static Display display = new Display();

    public static void main(String[] args) throws IOException {
        configurationLoader.loadProperties();
        display.displayCantorRunner();
    }
}