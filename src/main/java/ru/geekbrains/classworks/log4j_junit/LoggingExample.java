package ru.geekbrains.classworks.log4j_junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Trace << Debug << Info << Warn << Error << Fatal
public class LoggingExample {
    //    private static final Logger log = LogManager.getLogger();
//    private static final Logger log = LogManager.getLogger("root");
    private static final Logger log = LogManager.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        double d = .000324;
        String s = "Hi";

        log.info("Number = {} and string = {}", d, s);

        log.trace("Trace log");
        log.debug("Debug log");
        log.info("Info log");
        log.warn("Warn log");
        log.error("Error log");
        log.fatal("Fatal log");

        new Thread(() -> log.info("Another thread")).start();

        try {
            throw new RuntimeException("AAAAAAAAAAAAAA");
        } catch (RuntimeException e) {
            log.throwing(e);
        }
    }
}
