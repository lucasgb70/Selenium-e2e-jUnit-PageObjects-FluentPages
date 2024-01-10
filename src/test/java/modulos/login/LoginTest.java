package modulos.login;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

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
        String mensagemApresentada = new LoginPage(browser)
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Username is required", mensagemApresentada);
    }

    @Test
    @DisplayName("Testar login com user em branco")
    public void testLoginComUserEmBranco(){
        String mensagemApresentada = new LoginPage(browser)
                .informarASenha("secret_sauce")
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Username is required", mensagemApresentada);
    }

    @Test
    @DisplayName("Testar login com senha em branco")
    public void testLoginComSenhaEmBranco(){
        String mensagemApresentada = new LoginPage(browser)
                .informarOUsuario("standard_user")
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Password is required", mensagemApresentada);

    }

    @Test
    @DisplayName("Testar login com senha não existente e login existente")
    public void testLoginComSenhaNaoExistenteEUserExistente(){
        String mensagemApresentada = new LoginPage(browser)
                .informarOUsuario("standard_user")
                .informarASenha("Senha Incorreta")
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", mensagemApresentada);
    }

    @Test
    @DisplayName("Testar login com senha existente e login não existente")
    public void testLoginComSenhaExistenteEUserNaoExistente(){
        String mensagemApresentada = new LoginPage(browser)
                .informarOUsuario("User Errado")
                .informarASenha("secret_sauce")
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", mensagemApresentada);
    }

    @Test
    @DisplayName("Testar login com user e senha não existentes")
    public void testLoginComUserESenhaNãoExistentes(){
        String mensagemApresentada = new LoginPage(browser)
                .informarOUsuario("User Errado")
                .informarASenha("Senha Incorreta")
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", mensagemApresentada);
    }

    @Test
    @DisplayName("Testar login bloqueado")
    public void testLoginBloqueado(){
        String mensagemApresentada = new LoginPage(browser)
                .informarOUsuario("locked_out_user")
                .informarASenha("secret_sauce")
                .submeterFormularioLoginErro()
                .capturarMensagemErro();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", mensagemApresentada);
    }

    @Test
    @DisplayName("Testar login com credenciais válidas")
    public void testRealizarLoginNormal(){
        new LoginPage(browser)
                .informarOUsuario("standard_user")
                .informarASenha("secret_sauce")
                .submeterFormularioLogin()
                .verificaLoginSucesso()
                ;
        Assertions
    }

    @AfterEach
    public void afterEach(){
        //browser.quit();
    }
}
