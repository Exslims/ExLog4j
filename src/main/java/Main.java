import com.home.exlog4j.ExLogger;
import com.home.exlog4j.Logger;

/**
 * Created by sm0232 on 01.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = ExLogger.getLogger("application-profile");
        logger.debug("Hello , debug");

        for (int i = 0; i < 2000; i++) {
            logger.error("Error message" , new RuntimeException("Text exception"));
        }

    }
}
