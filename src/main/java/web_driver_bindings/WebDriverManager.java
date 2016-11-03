package web_driver_bindings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class WebDriverManager {
    
    static private WebDriver driver;
    
    static WebDriver getWebDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", OSBasedWebDriver.getWebDriverPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver =  new ChromeDriver(options);
        }
        return driver;
    }
    
    
    
    private static class OSBasedWebDriver {
    
        private  static String OS = System.getProperty("os.name").toLowerCase();
        
        private static String getWebDriverPath() {
    
            if (isWindows()) {
                return "bin/chromedriver.exe";
            } else if (isMac()) {
                return "bin/chromedriver_mac";
            } else if (isUnix()) {
                return "bin/chromedriver";
            
            } else {
                throw new RuntimeException("Your OS is not supported");
            }
        }
        
        private static boolean isWindows() {
            return (OS.contains("win"));
        }
    
        private static boolean isMac() {
            return (OS.contains("mac"));
        }
    
        private static boolean isUnix() {
            return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0 );
        }
        
    }
    
    
}
