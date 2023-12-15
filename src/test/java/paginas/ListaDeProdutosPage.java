package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver browser;

    public ListaDeProdutosPage(WebDriver browser){
        this.browser = browser;
    }

    public FormularioDeAdicaoDeProdutoPage acessarFormularioAdicaoNovoProduto(){
        //Vou para a tela de registro de produto
        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        return new FormularioDeAdicaoDeProdutoPage(browser);
    }

    public String capturarMensagemApresentada(){
        //Vou validar que a mensagem de erro foi apresentada
        // Buscando por duas classes no elemenmto<div class="toast rounded" style="top: 0px; transition: transform 0.2s ease 0s, opacity 0.2s ease 0s;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div>
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }

}
