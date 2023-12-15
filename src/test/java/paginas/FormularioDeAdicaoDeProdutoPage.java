package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver browser;

    public FormularioDeAdicaoDeProdutoPage(WebDriver browser){
        this.browser = browser;
    }

    public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto(String produtoNome){
        browser.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarValorProduto(String valorProduto){
        browser.findElement(By.name("produtovalor")).sendKeys(valorProduto);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarCoresProduto(String produtoCores){
        browser.findElement(By.id("produtocores")).sendKeys(produtoCores);
        return this;
    }

    //Aqui ja vai voltar para a página de lista de produtos
    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro(){
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(browser);
    }

    //Aqui ja vai voltar para a página de lista de produtos
    public FormularioEdicaoProdutoPage submeterFormularioDeAdicaoComSucesso(){
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new FormularioEdicaoProdutoPage(browser);
    }

}
