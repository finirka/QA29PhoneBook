package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm() {
            click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginForm(String email, String password) {
        //type(By.id("email"), email);
        //type(By.id("password"), password);
        type(By.cssSelector("[placeholder='Email']"),email);
        type(By.cssSelector("[placeholder='Password']"),password);

    }

    public void  fillLoginForm(User user){

        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[text()=' Login']"));

    }

    public boolean isRegistrated(){
        return isElementPresent(By.xpath("//a[@href='/contacts']"));
    }
/*
    public boolean notRegistrated(){
        return isElementPresent(By.xpath("//div[text()='LOADING...']"));
    }
*/
    public boolean isElementPresent (By locator){
        return wd.findElements(locator).size() > 0;
    }

    public void logout () {
        click(By.xpath("//div[@class='navbar-logged_nav__2Hx7M']//button"));
    }

    public boolean isLogOutPresent () {
        return isElementPresent(By.xpath("//div[button='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()=' Registration']"));
    }
    public boolean isNotRegistrated() {
        return isElementPresent(By.xpath("//div[text()='LOADING...']"));
    }
}
