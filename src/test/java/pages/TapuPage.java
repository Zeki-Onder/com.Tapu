package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Locale;

public class TapuPage {

    private WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    SoftAssert softAssert = new SoftAssert();

    By ucretsizKaydol = By.xpath("//a[@href='/kayit-ol']");
    By nameTextBox = By.xpath("//*[@id='_isim']");
    By surnameTextBox = By.xpath("(//*[@name='surname'])[1]");
    By countryCode = By.xpath("//*[@name='registerAreaCode']");
    By phoneNumberTextBox = By.xpath("(//*[@name='username'])[2]");
    By passwordTextBox = By.xpath("(//*[@name='password'])[2]");
    By marketingPermit = By.xpath("//label[@for='marketingPermit']");
    By agreementAprove = By.xpath("//label[@for='agreementApprove']");
    By singInBtnCnf = By.xpath("(//button[@class='btn btn-primary margin-top-2 btn-large btn-block'])[1]");
    By closeReload = By.xpath("//*[@class='close reload']");
    By infoLocate = By.xpath("//*[@class='has-sub-menu after-login-action']");
    By information = By.xpath("//a[@href='/hesabim?tab=account']");
    By infNameTextBox = By.xpath("//input[@name='firstName']");
    By infSurnameTextBox = By.xpath("//input[@name='lastName']");
    By infPhoneTextBox = By.xpath("//input[@name='phoneNumber']");
    By login = By.xpath("(//a[@href='/giris-yap'])[1]");
    By loginCountryCod = By.xpath("(//*[@name='loginAreaCode'])[1]");
    By loginUsername = By.xpath("(//*[@name='username'])[1]");
    By loginPassword = By.xpath("(//*[@name='password'])[1]");
    By loginBtnLogCnf = By.xpath("(//*[@class='btn btn-primary btn-large btn-block'])[1]");

    By titles = By.xpath("(//*[@class='group__link'])[]");

    public void clickUcretsizKaydol() {
        driver.findElement(ucretsizKaydol).click();
    }

    public void sendName(String name) {
        driver.findElement(nameTextBox).sendKeys(name);
    }

    public void sendSurname(String surname) {
        driver.findElement(surnameTextBox).sendKeys(surname);
    }

    public void selectContry(int index) {
        Select select = new Select(driver.findElement(countryCode));
        select.selectByIndex(index);
    }

    public void sendPhoneNo(String phoneNo) {
        driver.findElement(phoneNumberTextBox).sendKeys(phoneNo);
    }

    public void sendPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void checkMarketingPermit() {
        driver.findElement(marketingPermit).click();
    }

    public void checkAgreementAprove() {
        driver.findElement(agreementAprove).click();
    }

    public void clickSgnInCnf() {driver.findElement(singInBtnCnf).click();}

    public void clickCloseIcon() {driver.findElement(closeReload).click();}

    public String getInfoText() {
        String info = driver.findElement(infoLocate).getText();
        String usableText = info.subSequence(15, info.length()).toString();
        return usableText;
    }

    public void clickMyInformation() {
        actions.moveToElement(driver.findElement(infoLocate)).perform();
        Driver.waitFor(3);
        driver.findElement(information).click();
    }

    public String getTextInfName() {
        String firstName = driver.findElement(infNameTextBox).getAttribute("value");
        return firstName;
    }

    public String getTextInfSurname() {
        String lastName = driver.findElement(infSurnameTextBox).getAttribute("value");
        return lastName;
    }

    public String getTextInfPhoneNo() {
        String output = driver.findElement(infPhoneTextBox).getAttribute("value");
        return output;
    }

    public void loginClick() {
        driver.findElement(login).click();
    }

    public void loginCountry(int index) {
        Select select = new Select(driver.findElement(loginCountryCod));
        select.selectByIndex(index);
    }

    public void loginUername(String username) {
        driver.findElement(loginUsername).sendKeys(username);
    }

    public void loginPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtnLogCnf).click();
    }
    public void navigateToBottom(){
        for (int i=0;i<6;i++){
            Driver.waitFor(1);
            js.executeScript("window.scrollBy(0,1000)");
        }
    }

    public void clickableTitle(){
        int count=147;
        for (int i=0; i<8 ; i++){
            String homepage = driver.getCurrentUrl();
            driver.findElement(By.xpath("(//a[@href])["+count+"]")).click();
            Driver.waitFor(2);
            softAssert.assertFalse(driver.getCurrentUrl().equals(homepage));
            driver.navigate().back();
            Driver.waitFor(2);
            js.executeScript("window.scrollBy(0,1000)");
            count++;
        }

    }

    public void verifyTitle(){
        int count=147;
        js.executeScript("window.scrollBy(0,1000)");
        for (int i=0; i<8 ; i++){
            if (count != 148) {
                String countS = String.valueOf(i + 1);
                driver.findElement(By.xpath("(//a[@href])[" + count + "]")).click();
                Driver.waitFor(1);
                softAssert.assertEquals(ConfigReader.getProperty(countS).toLowerCase(Locale.forLanguageTag("Eng")),
                        driver.findElement(By.xpath("//h1")).
                                getText().toLowerCase(Locale.forLanguageTag("Eng")));
                Driver.waitFor(1);
                driver.navigate().back();
                Driver.waitFor(1);
                js.executeScript("window.scrollBy(0,1000)");}
                count++;


        }
    }
}
