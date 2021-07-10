package Ofertas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private WebDriver driver;
    @BeforeEach
    public void setUp()
    {
        driver = getDriver();
    }

    @Test
    public void getJobOffersTest() throws Exception {
            HomePage homePage = new HomePage(driver);
            TrabajaNosotros trabajaNosotros = new TrabajaNosotros(driver);

            homePage.open();
            assertTrue(homePage.isLoaded());
            driver.navigate().refresh();

            homePage.clicktrabajaConNosotrosLink();
            assertTrue(trabajaNosotros.isLoaded());
            trabajaNosotros.obtenerTodasLasOfertas();
    }

    @AfterEach
    public void cleanUp()
    {
        driver.quit();
    }

    private WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        return (WebDriver) new ChromeDriver();
    }
}
