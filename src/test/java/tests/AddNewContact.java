package tests;

import models.Contact;
import models.ContactNew;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{

    @BeforeMethod
    public void preCondition(){

        //login
        //if(!app.userHelper().isLogOutPresent()){
        //{}
        if(app.userHelper().isElementPresent (By.xpath("//a[@href='/contacts']"))){}
           else {
             app.userHelper().openLoginForm();
             app.userHelper().fillLoginForm("finirka@gmail.com","Finira12345$");
             app.userHelper().submitLogin();
             //Assert.assertTrue(app.userHelper().isRegistrated());
            }

    }

    @Test
    public void addNewContact(){
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Contact contact = new Contact()
                .withName("Anna"+i)
                .withLastName("Finn"+i)
                .withPhone("05399988"+i)
                .withEmail("finanka"+i+"@gmail.com")
                .withAddress("Tel Aviv Florentin"+i)
                .withDescription("My love");

        app.contactHelper().openContactForm();
        app.contactHelper().fillContactForm(contact);
        app.contactHelper().clickButtonSubmit();

    }

    @Test
    public void addNewContactN(){
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        ContactNew contact = ContactNew.builder()
                .name("Anna"+i)
                .lastName("Finn"+i)
                .phone("05399988"+i)
                .email("finanka"+i+"@gmail.com")
                .address("Tel Aviv Florentin"+i)
                .description("My love")
                .build();

        app.contactHelper().openContactForm();
        app.contactHelper().fillContactForm(contact);
        app.contactHelper().clickButtonSubmit();

    }

    @AfterMethod
    public void postCondition(){


    }
}
