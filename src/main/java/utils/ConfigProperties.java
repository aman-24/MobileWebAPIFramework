package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    public static String platform;
    public static String platformVersion;
    public static String deviceName;
    public static String activityName;
    public static String packageName;
    public static String androidApp;
    public static boolean noReset;

    public static String serverIP;
    public static String serverPort;

    public static String browser;

    public static String defaultWait;

    // --------------Creating ConfigProperties File-----------------
    public static File file = new File("./src/test/resources/config.properties");
    public static FileInputStream fis = null;
    public static Properties prop = new Properties();

    static{
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void initialize(){

        platform = prop.get("platform").toString();
        platformVersion = prop.get("platformVersion").toString();
        deviceName = prop.get("deviceName").toString();
        activityName = prop.get("appActivity").toString();
        packageName = prop.get("appPackage").toString();
        androidApp = prop.get("app").toString();
        noReset = Boolean.getBoolean(prop.get("noReset").toString());
        serverIP = prop.get("server_ip").toString();
        serverPort = prop.get("server_port").toString();
        browser = prop.get("browser").toString();
        defaultWait = prop.get("IMPLICIT_WAIT").toString();
    }

}
