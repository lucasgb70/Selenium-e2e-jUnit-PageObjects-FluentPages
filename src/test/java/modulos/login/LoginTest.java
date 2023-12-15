package modulos.login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes na area de login")
public class LoginTest {

    private WebDriver browser;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver\\chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.get("https://www.saucedemo.com/");
    }

    @Test
    @DisplayName("Testar login ambos em branco")
    public void testLoginComUserESenhaEmBranco(){
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Username is required", messageError);
    }

    @Test
    @DisplayName("Testar login com user em branco")
    public void testLoginComUserEmBranco(){
        browser.findElement(By.id("password")).sendKeys( "secret_sauce");
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Username is required", messageError);
    }

    @Test
    @DisplayName("Testar login com senha em branco")
    public void testLoginComSenhaEmBranco(){
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Password is required", messageError);
    }

    @Test
    @DisplayName("Testar login com senha não existente e login existente")
    public void testLoginComSenhaNaoExistenteEUserExistente(){
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys( "Senha Incorreta");
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", messageError);
    }

    @Test
    @DisplayName("Testar login com senha existente e login não existente")
    public void testLoginComSenhaExistenteEUserNaoExistente(){
        browser.findElement(By.id("user-name")).sendKeys("User Errado");
        browser.findElement(By.id("password")).sendKeys( "secret_sauce");
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", messageError);
    }

    @Test
    @DisplayName("Testar login com user e senha não existentes")
    public void testLoginComUserESenhaNãoExistentes(){
        browser.findElement(By.id("user-name")).sendKeys("User Errado");
        browser.findElement(By.id("password")).sendKeys( "Senha Incorreta");
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", messageError);
    }

    @Test
    @DisplayName("Testar login bloqueado")
    public void testLoginBloqueado(){
        browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
        browser.findElement(By.id("password")).sendKeys( "secret_sauce");
        browser.findElement(By.id("login-button")).click();

        String messageError = browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", messageError);
    }

    @AfterEach
    public void afterEach(){
        //browser.quit();
    }
}
