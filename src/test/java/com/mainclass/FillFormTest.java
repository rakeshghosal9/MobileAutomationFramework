package com.mainclass;

import com.pageobject.android.FormPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FillFormTest extends BaseConfiguration {

    @Test
    public void fillForm() throws InterruptedException {

        FormPage formPageTest = new FormPage(driver);
        formPageTest.setNameField("Rakesh");
        formPageTest.selectGender("Female");
        formPageTest.selectCountry("India");
        formPageTest.clickOnSubmitButton();
        Thread.sleep(5000);
    }

}
