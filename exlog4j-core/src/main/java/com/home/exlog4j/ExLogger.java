package com.home.exlog4j;

public class ExLogger implements Logger {

    private static ConfigsContainer configsContainer = ConfigsContainer.getInstance();

    public static ExLogger getLogger(Class targetClass){
        return null;
    }
    public static ExLogger getLogger(String customName){
       return null;
    }
    public static ExLogger getLogger(Class targetClass, String profileName){
        return null;
    }
    public static ExLogger getLogger(String customName, String profileName){
        return null;
    }

    public void trace(Object message) {

    }

    public void debug(Object message) {

    }

    public void info(Object message) {

    }

    public void warn(Object message) {

    }

    public void error(Object message) {

    }

    public void error(Object object, Throwable throwable) {

    }

    public void fatal(Object message) {

    }

    public void fatal(Object object, Throwable throwable) {

    }

    public Level getLevel() {
        return null;
    }

    public Level setLevel(Level level) {
        return null;
    }

    public String getProfileName() {
        return null;
    }

    public void setProfileName(String profileName) {

    }
}
