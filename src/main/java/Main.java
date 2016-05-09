import com.home.exlog4j.ExLogger;
import com.home.exlog4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = ExLogger.getLogger(Main.class , "application-profile");
        logger.debug("Hello , debug");
        for (int i = 0; i < 2000; i++) {
            logger.error("Error message" , new RuntimeException("Text exception"));
        }
    }
}
