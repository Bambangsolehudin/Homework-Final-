package FeatureLogout.stepDef;

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

public class Logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on saucedemo login page")
    public void user_is_on_saucedemo_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("user input (.*) as username$")
    public void user_input_tdd_selenium_gmail_com_as_email(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }


    @And("user input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click submit")
    public void user_click_submit() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @And("user click humberger menu")
    public void user_click_humberger_menu() {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    @And("user click logout menu")
    public void user_click_logout_menu() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("user success logout")
    public void user_success_logout(){
        String login = driver.findElement(By.id("login-button")).getAttribute("value");
        Assert.assertEquals(login, "Login");
    }

}
