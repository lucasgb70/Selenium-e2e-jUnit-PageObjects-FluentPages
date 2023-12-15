package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver browser;

    public LoginPage(WebDriver browser){
        this.browser = browser;
    }
    //Se vai preencher e ficar na mesma página retorna a mesma página se for pra próxima página,
    // informaria ao inves de loginpage a próxima page
    public LoginPage informarOUsuario(String usuario){
        browser.findElement(By.cssSelector("label[for='usuario']")).click();
        browser.findElement(By.id("usuario")).sendKeys(usuario);
        return this;
    }

    public LoginPage informarASenha(String senha){
        browser.findElement(By.cssSelector("label[for='senha']")).click();
        browser.findElement(By.id("senha")).sendKeys(senha);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin(){
        browser.findElement(By.name("action")).click();
        return new ListaDeProdutosPage(browser);
    }
}
