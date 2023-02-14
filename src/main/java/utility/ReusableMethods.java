package utility;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    AndroidDriver driver;
    public ReusableMethods(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public boolean performLongPress(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
            ));
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred while performing long press : " + e);
            return false;
        }
    }

    public boolean performScroll(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred while performing scroll : " + e);
            return false;
        }
    }

    public boolean performSwipe(WebElement element,String swipeDirection) {
        try {
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(), "direction", swipeDirection, "percent", 0.75
            ));
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred while performing swipe : " + e);
            return false;
        }
    }

    public boolean performDragAndDrop(WebElement element, int endX, int endY) {
        try {
            ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(), "endX", endX, "endY", endY
            ));
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred while performing drag and drop : " + e);
            return false;
        }
    }

    public boolean waitForAnElementToBeVisible(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element ["+element+"] is displayed");
            return true;
        } catch (Exception e) {
            System.out.println("Element not visible after [" + seconds + "] seconds");
            return false;
        }
    }
}
