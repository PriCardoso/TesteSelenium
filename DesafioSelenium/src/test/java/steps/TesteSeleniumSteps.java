package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Carro;
import helpers.DriverNavegador;
import helpers.Pessoa;
import helpers.Seguro;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

import static org.junit.Assert.assertEquals;

public class TesteSeleniumSteps {
	
	WebDriver driver;
	
	@Before
	public void TesteSellenium () {
		
		driver = new DriverNavegador().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Dado("que estou no site da sampleapp")
	public void que_estou_no_site_da_sampleapp() {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		String resultadoEsperado = "Enter Vehicle Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
	}
	
	@Dado("preencho o formulário Vehicle Data e pressione next")
	public void preencho_o_formulário_vehicle_data_e_pressione_next() {
		Carro dadoscarro = new Carro();
		
		WebElement make	=	driver.findElement(By.id("make"));
		Select select	=	new	Select(make);
	    select.selectByVisibleText("Ford");
	    
	    WebElement modelo	=	driver.findElement(By.id("model"));
		select	=	new	Select(modelo);
	    select.selectByVisibleText("Moped");
	    
	    driver.findElement(By.id("cylindercapacity")).sendKeys(dadoscarro.capacidade);
	    driver.findElement(By.name("[kW]")).sendKeys(dadoscarro.performance);
	    driver.findElement(By.id("dateofmanufacture")).sendKeys(dadoscarro.manufacture);
	    
	    WebElement seats	=	driver.findElement(By.id("numberofseats"));
		select	=	new	Select(seats);
	    select.selectByVisibleText("5");
	    
	    driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[2]/span")).click();
	    
	    WebElement seats2	=	driver.findElement(By.id("numberofseatsmotorcycle"));
		select	=	new	Select(seats2);
	    select.selectByVisibleText("3");
	    
	    WebElement combustivel	=	driver.findElement(By.id("fuel"));
		select	=	new	Select(combustivel);
	    select.selectByVisibleText("Electric Power");
	    
	    driver.findElement(By.id("payload")).sendKeys(dadoscarro.payload);
	    driver.findElement(By.id("totalweight")).sendKeys(dadoscarro.peso);
	    driver.findElement(By.id("listprice")).sendKeys(dadoscarro.price);
	    
	    driver.findElement(By.id("licenseplatenumber")).sendKeys(dadoscarro.license);
	    driver.findElement(By.id("annualmileage")).sendKeys(dadoscarro.mileage);
	    
	    String resultadoEsperado = "Enter Vehicle Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		
	    driver.findElement(By.id("nextenterinsurantdata")).click();
	}
	
	@Dado("preencho o formulário Insurant Data e pressione next")
	public void preencho_o_formulário_insurant_data_e_pressione_next() {
		Pessoa dadospessoa = new Pessoa();
		driver.findElement(By.id("firstname")).sendKeys(dadospessoa.nome);
		driver.findElement(By.id("lastname")).sendKeys(dadospessoa.sobrenome);
		driver.findElement(By.id("birthdate")).sendKeys(dadospessoa.nascimento);
		
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[2]/span")).click();
		
		
		driver.findElement(By.id("streetaddress")).sendKeys(dadospessoa.endereco);
		
		WebElement pais	=	driver.findElement(By.id("country"));
		Select select	=	new	Select(pais);
	    select.selectByVisibleText("Brazil");
	    
	    driver.findElement(By.id("zipcode")).sendKeys(dadospessoa.cep);
	    driver.findElement(By.id("city")).sendKeys(dadospessoa.cidade);
	    
	    WebElement ocupacao	=	driver.findElement(By.id("occupation"));
		select	=	new	Select(ocupacao);
	    select.selectByVisibleText("Employee");
	    
	    driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[2]/span")).click();
	    driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[4]/span")).click();
	    
	    driver.findElement(By.id("website")).sendKeys(dadospessoa.website);
	    	        
	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"picture\"]")); 
	    fileInput.sendKeys(dadospessoa.caminhofoto); 
	    
	    String resultadoEsperado = "Enter Insurant Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
	
	    driver.findElement(By.id("nextenterproductdata")).click();
	}
	
	@Dado("preencho o formulárioProduct Data e pressione next")
	public void preencho_o_formulário_product_data_e_pressione_next() {
		Seguro dadosseguro = new Seguro();
		driver.findElement(By.id("startdate")).sendKeys(dadosseguro.datacomeco);
		
		WebElement insuranceSum	=	driver.findElement(By.xpath("//*[@id=\"insurancesum\"]"));
		Select select	=	new	Select(insuranceSum);
	    select.selectByValue("35000000");
	
	    WebElement rating	=	driver.findElement(By.id("meritrating"));
		select	=	new	Select(rating);
	    select.selectByVisibleText("Malus 11");
	    
	    WebElement damage	=	driver.findElement(By.id("damageinsurance"));
		select	=	new	Select(damage);
	    select.selectByVisibleText("Full Coverage");
	    
	    driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")).click();
	    
	    
	    WebElement carroCortesia	=	driver.findElement(By.xpath("//*[@id=\"courtesycar\"]"));
		select	=	new	Select(carroCortesia);
	    select.selectByVisibleText("Yes");
	    
	    String resultadoEsperado = "Enter Product Data";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
	    
	    driver.findElement(By.id("nextselectpriceoption")).click();
	}
	
	@Dado("preencho o formulário Price Option e pressione next")
	public void preencho_o_formulário_price_option_e_pressione_next() {
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]/span")).click();
		
		String resultadoEsperado = "Select Price Option";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		
		driver.findElement(By.id("nextsendquote")).click();
	}
	
	@Dado("preencho o formulário Send Quote e pressione Send")
	public void preencho_o_formulário_send_quote_e_pressione_send() {
		Seguro dadosseguro = new Seguro();
		driver.findElement(By.id("email")).sendKeys(dadosseguro.email);
		driver.findElement(By.id("phone")).sendKeys(dadosseguro.telefone);
		driver.findElement(By.id("username")).sendKeys(dadosseguro.nomeDeUsuario);
		driver.findElement(By.id("password")).sendKeys(dadosseguro.senha);
		driver.findElement(By.id("confirmpassword")).sendKeys(dadosseguro.confirmaSenha);
		driver.findElement(By.id("Comments")).sendKeys(dadosseguro.comentario);
		
		String resultadoEsperado = "Send Quote";
		Assert.assertEquals(resultadoEsperado, driver.getTitle());
		
		driver.findElement(By.id("sendemail")).click();
	}
	
	@Então("vejo a mensagem na tela a mensagem {string}")
	public void vejo_a_mensagem_na_tela_a_mensagem(String string) {
		String textoElement = driver.findElement(By.xpath("/html/body/div[4]/h2")).getText();
	    assertEquals("Sending e-mail success!", textoElement);
	}
	@After
	public void dps() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.quit();
	}
}