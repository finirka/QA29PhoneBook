package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.userHelper().isLogOutPresent()){
            app.userHelper().logout();}
    }

    @Test
    public void registrationSuccess() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.userHelper().openLoginForm();
        //app.userHelper().fillRegistrationForm("Noa","Last","noa"+i+"@gmail.com","Nnoa12345$");
        app.userHelper().fillLoginForm("finirka"+ i +"@gmail.com","Finira12"+ i + "$");
        app.userHelper().submitRegistration();
        Assert.assertTrue(app.userHelper().isRegistrated());
    }

    @Test
    public void registrationSuccessModel(){
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withEmail("finirka"+ i + "@gmail.com").withPassword("Finira12"+ i + "$");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitRegistration();
        //Assert.assertTrue(app.userHelper().isLogged());
        Assert.assertTrue(app.userHelper().isRegistrated());
    }
    @AfterMethod
    public void postCondition(){

        //app.userHelper().clickOkButton();
    }
}
