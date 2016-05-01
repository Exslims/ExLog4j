import com.home.exlog4j.ExLogger;
import com.home.exlog4j.Logger;

/**
 * Created by sm0232 on 01.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = ExLogger.getLogger("");
        logger.debug("Hello , debug");
        logger.error("Error message" , new RuntimeException("Text exception"));
    }
}
