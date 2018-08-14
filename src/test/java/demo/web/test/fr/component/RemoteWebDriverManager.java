package demo.web.test.fr.component;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import com.google.common.base.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.opera.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoteWebDriverManager {
	
	public static final String DRIVERPATH_FIREFOX_PROPERTY_KEY="webdriver.gecko.driver";
	public static final String DRIVERPATH_CHROME_PROPERTY_KEY="webdriver.chrome.driver";	
	public static final String DRIVERPATH_IE_PROPERTY_KEY="webdriver.ie.driver";
	
	
	
	//firefox linux64 geckodriver:v0.20.0 download location: https://github.com/mozilla/geckodriver/releases/download/v0.20.0/geckodriver-v0.20.0-linux64.tar.gz
	//chrome linux64 chrome driver:2.35 download location  http://chromedriver.storage.googleapis.com/2.35/chromedriver_linux64.zip
	
	public static final String DRIVERPATH_FIREFOX_PROPERTY_VAL=RemoteWebDriverManager.getAbsoluteFilePath("browserdrivers/firefox/geckodriver");
	public static final String DRIVERPATH_CHROME_PROPERTY_VAL=RemoteWebDriverManager.getAbsoluteFilePath("browserdrivers/chrome/chromedriver");
	
	public static final String DRIVERPATH_FIREFOX_PROPERTY_VAL_WIN=RemoteWebDriverManager.getAbsoluteFilePath("browserdriverswin/firefox/geckodriver.exe");
	public static final String DRIVERPATH_CHROME_PROPERTY_VAL_WIN=RemoteWebDriverManager.getAbsoluteFilePath("browserdriverswin/chrome/chromedriver.exe");
	public static final String DRIVERPATH_IE_PROPERTY_VAL_WIN=RemoteWebDriverManager.getAbsoluteFilePath("browserdriverswin/ie/IEDriverServer.exe");
	
	
	public static String getAbsoluteFilePath(String filename){
		String retfilewithfullpath="";
		retfilewithfullpath=filename;
		Path pathfile = Paths.get(filename);
		Path path = Paths.get("");
	    Path effectivePath = path;
	    if (!pathfile.isAbsolute()) {
	        Path base = Paths.get("");
	        effectivePath = base.resolve(path).toAbsolutePath();
	        retfilewithfullpath=effectivePath.normalize().toString() + "/" + filename;
	    }
	    return retfilewithfullpath;
	}
	
	public static ChromeOptions getChromeOptions() {
		 ChromeOptions  options = new ChromeOptions();
		 if (isWinOS()){
			 System.setProperty(DRIVERPATH_CHROME_PROPERTY_KEY, DRIVERPATH_CHROME_PROPERTY_VAL_WIN);
		 }
		 else{
			 options.setHeadless(true);
			 System.setProperty(DRIVERPATH_CHROME_PROPERTY_KEY, DRIVERPATH_CHROME_PROPERTY_VAL);
		 }
		 
		 return options;
	}
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions  options = new FirefoxOptions();
		if (isWinOS()){
			System.setProperty(DRIVERPATH_FIREFOX_PROPERTY_KEY, DRIVERPATH_FIREFOX_PROPERTY_VAL_WIN);
		 }
		 else{
			options.setHeadless(true);
			System.setProperty(DRIVERPATH_FIREFOX_PROPERTY_KEY, DRIVERPATH_FIREFOX_PROPERTY_VAL);
		 }
		 
		 return options;
	}
	public static InternetExplorerOptions getIEOptions() throws Exception {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("ignoreZoomSetting", true);
		options.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		//options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		
		//options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		//options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		//options.enablePersistentHovering();
		//options.ignoreZoomSettings();
	
		
		if (isWinOS()){
			System.setProperty(DRIVERPATH_IE_PROPERTY_KEY, DRIVERPATH_IE_PROPERTY_VAL_WIN);
		 }
		 else{
			throw new Exception("Linux will not support IE Driver, Please change the configurations NOT to use IE in LINUX");
		 }
		 
		 return options;
	}
	public static boolean isWinOS(){
		String str = System.getProperty("os.name").toLowerCase();
		if (str.contains("win")) {
		    return true;
		}
		else{
			return false;
		}
	}
	
	
}
