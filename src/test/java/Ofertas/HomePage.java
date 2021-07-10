package Ofertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By trabajaConNosotrosLink() { return By.xpath("(//*[@id='mega-menu-item-1541']/a)[1]"); }
    By cerrarPopup() { return By.xpath("//div[@id='sgpb-popup-dialog-main-div-wrapper']"); }

    public void open() {
        driver.get("https://www.sophossolutions.com/");
    }

    public boolean isLoaded() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cerrarPopup())).isDisplayed();
    }



    public void clicktrabajaConNosotrosLink(){
        driver.findElement(trabajaConNosotrosLink()).click();
    }

}
