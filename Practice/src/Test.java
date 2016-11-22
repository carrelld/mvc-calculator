import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    public static final Logger log = LogManager.getLogger(Test.class.getName());
    
    public static void main(String[] args) {
        log.trace("trace logged");
        log.info("info logged");
        log.warn("Warn logged!");
    }

}
