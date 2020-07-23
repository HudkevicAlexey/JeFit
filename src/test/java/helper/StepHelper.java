package helper;

import io.qameta.allure.model.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.qameta.allure.Allure.step;

public class StepHelper {

    private final Logger log = LogManager.getRootLogger();

    public void info(String message) {
        log.info(message);
        step(message);
    }

    public void info(String message, boolean isTrue) {
        log.info(message);
        step(message, isTrue ? Status.PASSED : Status.FAILED);
    }

    public void error(String message) {
        log.error(message);
        step(message, Status.FAILED);
    }
}
