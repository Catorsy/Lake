import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class); //подключаем для каждого класса
//логгеры привязаны к классу, а не к объекту
    public static void main(String[] args) {
        LOG.trace("I am trace");
        LOG.debug("I am debug");
        LOG.info("I am info");
        LOG.warn("I am warn");
        LOG.error("I am error");
        LOG.fatal("I am fatal");
        divide(5, 0);
    }

    public static int divide(int a, int b) {
        if(b == 0){
            LOG.error("Parameter b={}", b);
            throw new IllegalArgumentException();
        }
        return a/b;
    }
}
