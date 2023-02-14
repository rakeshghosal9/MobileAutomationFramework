package com.mainclass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseConfiguration {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        /*service = new AppiumServiceBuilder().withAppiumJS(new File(
                "C:\\Users\\Rakesh.Ghosal\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();*/
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Appium_1");
        options.setApp("C:\\Users\\Rakesh.Ghosal\\Documents\\IntellijWorkspace\\AppiumLearning\\src\\test\\java\\com\\resources\\General-Store.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        //service.stop();
    }

}
