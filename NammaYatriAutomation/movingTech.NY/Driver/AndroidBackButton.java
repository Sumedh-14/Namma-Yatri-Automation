package Driver;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseClass;

public class AndroidBackButton extends BaseClass {

    public void tapBack() throws InterruptedException {

        checkAndNavigateBack("//android.widget.RelativeLayout[@content-desc=\"Activate to open step list\"]"
                + "/android.widget.RelativeLayout/android.widget.RelativeLayout"
                + "/android.widget.LinearLayout/android.widget.LinearLayout", "Validating whether the route in map is displaying.");

        checkAndNavigateBack("//android.view.View[@content-desc=\"Start driving navigation\"]", "Validating whether the start Navigation screen is displaying.");

        checkAndNavigateBack("//android.widget.TextView[@text=\"Search here\"]", "Validating whether the Gmap HomeScreen is displaying.");
    }

    private void checkAndNavigateBack(String xpath, String validationMessage) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Assert.assertTrue(element.isDisplayed(), validationMessage);
            System.out.println(validationMessage + " - PASSED");
            driver.navigate().back();
        } catch (NoSuchElementException e) {
            System.out.println(validationMessage + " - FAILED");
        }
    }
}
