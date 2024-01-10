package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LoginPage {
    private WebDriver browser;

    public LoginPage(WebDriver browser){
        this.browser = browser;
    }

    public LoginPage informarOUsuario(String usuario){
        browser.findElement(By.id("user-name")).sendKeys(usuario);
        return this;
    }

    public LoginPage informarASenha(String senha){
        browser.findElement(By.id("password")).sendKeys( senha);
        return this;
    }

    public LoginPage submeterFormularioLoginErro(){
        browser.findElement(By.id("login-button")).click();
        return this;
        //return new ListaDeProdutosPage(browser);
    }

    public String capturarMensagemErro(){
        return browser.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }

    public ListaDeProdutosPage submeterFormularioLogin(){
        browser.findElement(By.id("login-button")).click();
        return new ListaDeProdutosPage(browser);
    }

}
