package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
//public class base extends AndroidPool {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static Properties prop;

	//connect assertion port(expected, actual)
	public AppiumDriverLocalService startServer() {
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}

	//methods logic to make sure no port usable
		public static boolean checkIfServerIsRunnning(int port) {

			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);

				serverSocket.close();
			} catch (IOException e) {
				// If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
			
		}

	public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException {

		// file params using 'properties'
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		
		// provide desiredCapabilities & apk name
		//File appDir = new File("src");
		//File app = new File(appDir, (String) prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// start emulator automatically
		String device = (String) prop.get("devicereal");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		//capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());   
	    capabilities.setCapability("appWaitPackage", "com.saucelabs.mydemoapp.android");
    	capabilities.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	//create script to invoke the emulator using cmd formatted .bat file
		public static void startEmulator() throws IOException, InterruptedException {
			
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
			Thread.sleep(6000);
		}

//	public String getScreenshotPath(String testCaseName, AndroidDriver<AndroidElement> driver) throws IOException {
//		// TODO Auto-generated method stub
//		// Declare Screenshot methods
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
//		
//		//must add dependency "Apache Commons IO"
//		FileUtils.copyFile(source, new File(destinationFile));
//		return destinationFile;
//	}
	
	public static void getScreenshot(String testCaseName) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"));
	
	}
	
}
