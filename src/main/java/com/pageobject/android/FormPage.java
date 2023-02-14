package com.pageobject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.ReusableMethods;

public class FormPage extends ReusableMethods {
    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryNameDropdown;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            maleRadioButton.click();
        } else {
            femaleRadioButton.click();
        }
    }

    public void selectCountry(String countryName) {
        countryNameDropdown.click();
        performScroll(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
    }

    public void clickOnSubmitButton() {
        btnLetsShop.click();
    }


}
