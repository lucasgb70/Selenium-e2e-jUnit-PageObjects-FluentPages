package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver browser;

    public ListaDeProdutosPage(WebDriver browser){
        this.browser = browser;
    }

    public String verificaLoginSucesso(){
        return browser.findElement(By.className("shopping_cart_container")).getText();
    }

    public ListaDeProdutosPage adicionaItemNoCarrinho(String id,Double chartValue){
        browser.findElement(By.id(id)).click();
        return this;
    }

    public ListaDeProdutosPage somaValorDoProdutoNoCarrinho(String id,Double chartValue){
        browser.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]")).click();
        String valueWithoutDollarSign = browser.findElement(By.className("inventory_details_price")).getText().replaceAll("[$]", "");
        chartValue += Double.parseDouble(valueWithoutDollarSign);
        browser.findElement(By.id("back-to-products")).click();
        return this;
    }



    public String capturarMensagemApresentadaViaClass(String className){
        return browser.findElement(By.className(className)).getText();
    }

}
