package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.userHelper().isLogOutPresent()){
            app.userHelper().logout();}
    }

    @Test
    public void loginSuccess(){

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("finirka@gmail.com","Finira12345$");
        app.userHelper().submitLogin();
        Assert.assertTrue(app.userHelper().isRegistrated());

    }

    @Test
    public void loginSuccessModel(){
        User user = new User()
                .withEmail("finirka@gmail.com").withPassword("Finira12345$");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();
        //Assert.assertTrue(app.userHelper().isLogged());
        Assert.assertTrue(app.userHelper().isRegistrated());
    }

    @Test
    public void negativeLoginWrongPassword(){
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("finirka@gmail.com","Finira12345");
        app.userHelper().submitLogin();

        //Assert.assertFalse(app.userHelper().isRegistrated());
        Assert.assertTrue(app.userHelper().isNotRegistrated());
    }


    @AfterMethod
    public void postCondition(){

        //app.userHelper().clickOkButton();
    }
}

