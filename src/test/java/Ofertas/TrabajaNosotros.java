package Ofertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TrabajaNosotros {

    private final WebDriver driver;

    public TrabajaNosotros(WebDriver driver) {
        this.driver = driver;
    }

    By TodasLasOfertas() { return By.cssSelector("div.empty-thumb"); }

    public boolean isLoaded() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2"))).isDisplayed();
    }
    
    public void obtenerTodasLasOfertas(){
        List<WebElement> ofertas = driver.findElements(TodasLasOfertas());
        String nombre ="";
        String fecha ="";
        String descripcion ="";
        int i=0;

        for (WebElement oferta: ofertas) {
            i++;
            nombre = oferta.findElement(By.cssSelector("div.premium-blog-entry-container>h3>a")).getText();
            fecha = oferta.findElement(By.cssSelector("div.premium-blog-entry-container>div>span>span")).getText();
            descripcion = oferta.findElement(By.cssSelector(".premium-blog-post-content")).getText();

            System.out.println("Nombre oferta " +i +":"+ nombre);
            System.out.println("fecha oferta " +i +":"+ fecha);
            System.out.println("descripcion oferta " +i +":"+ descripcion);
        }
    }
}
