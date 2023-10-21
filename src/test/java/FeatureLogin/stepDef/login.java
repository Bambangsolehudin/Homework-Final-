package FeatureLogin.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on saucedemo login page")
    public void user_is_on_saucedemo_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("user input (.*) as username$")
    public void user_input_tdd_selenium_gmail_com_as_username(String email){
        driver.findElement(By.id("user-name")).sendKeys(email);
    }


    @And("user input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click submit")
    public void user_click_submit() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status){
        if(status.equals("success")){
//            driver.findElement(By.xpath("//div[contains(text(), 'dashboard')]")).getText();
            String products = driver.findElement(By.xpath("//span[@class='title']")).getText();
            Assert.assertEquals(products, "Products");
        } else {
            String errorLogin = driver.findElement((By.xpath("//h3[@data-test='error']"))).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        }
    }





}
