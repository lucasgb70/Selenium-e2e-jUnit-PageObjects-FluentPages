package modulos.produtos;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.ListaDeProdutosPage;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes na area de login")
public class ProductsTest {

    private WebDriver browser;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver\\chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.get("https://www.saucedemo.com/");
        //Realiza login para iniciar os testes nos produtos
        new LoginPage(browser)
                .informarOUsuario("standard_user")
                .informarASenha("secret_sauce")
                .submeterFormularioLogin();
    }

    @Test
    @DisplayName("Testar adicionar um produto no carrinho")
    public void testAdicionarUmProdutoNoCarrinho(){
        String mensagemApresentada = new ListaDeProdutosPage(browser)
                .adicionaItemNoCarrinho("add-to-cart-sauce-labs-backpack", 0.00)
                .capturarMensagemApresentadaViaClass("shopping_cart_badge");
        Assertions.assertEquals("1", mensagemApresentada);
    }

    /*@Test
    @DisplayName("Testar adicionar um produto no carrinho")
    public void testAdicionarTresProdutosNoCarrinho(){
        String mensagemApresentada = new ListaDeProdutosPage(browser)
                .adicionaItemNoCarrinho("add-to-cart-sauce-labs-backpack")
                .adicionaItemNoCarrinho("add-to-cart-sauce-labs-bike-light")
                .adicionaItemNoCarrinho("add-to-cart-sauce-labs-bolt-t-shirt")
                .capturarMensagemApresentadaViaClass("shopping_cart_badge");
        Assertions.assertEquals("3", mensagemApresentada);
    } */

    @AfterEach
    public void afterEach(){
        //browser.quit();
    }
}
