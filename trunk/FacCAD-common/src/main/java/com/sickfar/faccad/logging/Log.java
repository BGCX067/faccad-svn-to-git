package com.sickfar.faccad.logging;

import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA.
 * User: sickfar
 * Date: 09.02.13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class Log {

    private static org.apache.commons.logging.Log log = LogFactory.getLog(Log.class);

    public static synchronized void trace(Object message) {
        log.trace(message);
    }

    public static synchronized void trace(Object message, Throwable t) {
        log.trace(message, t);
    }

    public static synchronized void debug(Object message) {
        log.debug(message);
    }

    public static synchronized void debug(Object message, Throwable t) {
        log.debug(message, t);
    }

    public static synchronized void info(Object message) {
        log.info(message);
    }

    public static synchronized void info(Object message, Throwable t) {
        log.info(message, t);
    }

    public static synchronized void warn(Object message) {
        log.warn(message);
    }

    public static synchronized void warn(Object message, Throwable t) {
        log.warn(message, t);
    }

    public static synchronized void error(Object message) {
        log.error(message);
    }

    public static synchronized void error(Object message, Throwable t) {
        log.error(message, t);
    }

    public static synchronized void fatal(Object message) {
        log.fatal(message);
    }

    public static synchronized void fatal(Object message, Throwable t) {
        log.fatal(message, t);
    }

}
