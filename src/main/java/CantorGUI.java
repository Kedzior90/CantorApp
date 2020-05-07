import utils.ConfigurationLoader;
import utils.MainPanelGUI;
import java.io.FileNotFoundException;

//http://ggoralski.pl/?p=744
//http://jsystems.pl/blog/artykul.html?id=108
//https://www.guru99.com/java-swing-gui.html

public class CantorGUI {
    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) throws FileNotFoundException {
        configurationLoader.loadProperties();
        new MainPanelGUI();
    }
}
