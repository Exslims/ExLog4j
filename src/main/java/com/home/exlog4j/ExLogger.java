package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * Implementation of {@link Logger} interface
 */
public class ExLogger implements Logger {

    /**
     * Singleton instance of ConfigsContainer
     */
    private static ConfigsContainer configsContainer = ConfigsContainer.getInstance();


    /**
     * Constructs new ExLogger instance by targetClass and profileName
     * @param targetClass class parameter
     * @param profileName name of target profile
     * @return new constructed ExLogger instance
     */
    public static ExLogger getLogger(Class targetClass , String profileName){
        return new ExLogger(targetClass.getSimpleName() , profileName);
    }

    /**
     * Constructs new ExLogger instance by profileName
     * @param profileName name of target profile
     * @return new constructed ExLogger instance
     */
    public static ExLogger getLogger(String profileName){
        return new ExLogger(ExLogger.detectClassName() , profileName);
    }

    private ExConfig exConfig;
    private String profileName;
    private String targetClassName;

    private ExLogger(String target, String profileName) {
        this.targetClassName = target;
        this.setProfileName(profileName);
    }

    public void trace(Object message) {
        this.log(Level.TRACE , message , targetClassName);
    }

    public void debug(Object message) {
        this.log(Level.DEBUG , message , targetClassName);
    }


    public void info(Object message) {
        this.log(Level.INFO , message , targetClassName);
    }

    public void warn(Object message) {
        this.log(Level.WARN , message , targetClassName);
    }

    public void error(Object message) {
        this.log(Level.ERROR , message , targetClassName);
    }

    public void error(Object message, Throwable throwable) {
        String fullStackTrace = ExceptionUtils.getFullStackTrace(throwable);
        this.log(Level.ERROR ,message + ": " + fullStackTrace, targetClassName);
    }

    public void fatal(Object message) {
        this.log(Level.ERROR , message , targetClassName);
    }

    public void fatal(Object message, Throwable throwable) {
        String fullStackTrace = ExceptionUtils.getFullStackTrace(throwable);
        this.log(Level.FATAL ,message + ": " + fullStackTrace, targetClassName);
    }

    public Level getLevel() {
        return Level.valueOf(exConfig.getLogLevel());
    }

    public void setLevel(Level level) {
      this.exConfig.setLogLevel(String.valueOf(level));
    }

    public String getProfileName() {
        return this.profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
        this.exConfig = configsContainer.getConfig(profileName);
    }

    private void log(Level level , Object message , String target) {
        this.exConfig.getAppenderList().stream().forEach((appender ->
                appender.sendMessage(level.toString() , message.toString() , target))
        );
    }

    private static String detectClassName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTraceElements[stackTraceElements.length-1];
        return stackTraceElement.getClassName();
    }
}
