package com.log.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {

    private static Logger logger = Logger.getLogger(Log4j.class);

    private void showLog(){
        logger.info("log--log--log");
    }

    public static void main(String[] args){
        String rootPath = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        System.out.println(rootPath + separator + "config" + separator + "log4j.properties");
        PropertyConfigurator.configure(rootPath + separator + "config" + separator + "log4j.properties");
        new Log4j().showLog();
    }
}
