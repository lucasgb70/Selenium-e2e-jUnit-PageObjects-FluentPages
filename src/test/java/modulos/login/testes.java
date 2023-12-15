import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testes {
    private WebDriver browser;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver\\chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.get("https://hom-viagem-reembolso-apps.pr.sebrae.com.br/login?token=c72b917b-87c3-4fcb-ba4d-002cd45364ea");
    }

    @Test
    @DisplayName("Solicitaçao viagem nacional terceiro")
    public void testSolicitacaoViagemNacionalTerceiro(){
        browser.findElement(By.cssSelector("div[class='closed hide-on-print ng-star-inserted']")).click();
        WebElement element = browser.findElement(By.xpath("//html/body/app-root/app-main-public/div/div/app-sidebar/div/div[3]"));
        Actions actions = new Actions(browser);
        actions.moveToElement(element).click().build().perform();
    }
}