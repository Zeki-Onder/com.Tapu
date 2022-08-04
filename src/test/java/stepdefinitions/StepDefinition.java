package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.TapuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;

import javax.accessibility.AccessibleTable;

public class StepDefinition extends TapuPage {

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String surname = faker.name().lastName();
    int indexB = faker.number().numberBetween(1, 21);
    String phoneNo = faker.numerify("##########");
    String password = faker.internet().password();
    String mainUrl ;



    @Given("User navigate to {string}")
    public void user_navigate_to(String url) {
        Log.startTestCase("Test");
        Driver.getDriver().navigate().to(ConfigReader.getProperty(url));
        Log.info("Homepage opened");
        mainUrl=Driver.getDriver().getCurrentUrl();
    }

    @Then("Click -Ucretsiz Uye Ol- button")
    public void click_ucretsiz_uye_ol_button() {
        clickUcretsizKaydol();
        Log.info("Ucretsiz uye ol button clicked");
    }

    @Then("Insert requested data")
    public void ınsert_requested_data() {
        sendName(name);
        sendSurname(surname);
        selectContry(indexB);
        sendPhoneNo(phoneNo);
        sendPassword(password);
        Log.info("Required data sent");
    }

    @Then("Click checkbox")
    public void click_checkbox() {
        checkMarketingPermit();
        Log.info("Marketing Permited");
        checkAgreementAprove();
        Log.info("Agreement Aproved");
    }

    @Then("Click sing in button")
    public void clickSingInButton() throws InterruptedException {
        Driver.waitFor(3);
        clickSgnInCnf();
        Log.info("Click Sign in Button");
    }

    @Given("The modul of Number Verify cancel with click x")
    public void the_modul_of_number_verify_cancel_with_click_x() throws InterruptedException {
        Driver.waitFor(3);
        clickCloseIcon();
        Log.info("Closed Numeric Verify");
    }

    @Then("Name used during registration verify with name in the homepage")
    public void name_used_during_registration_verify_with_name_in_the_homepage() {
        Assert.assertEquals(getInfoText(),name+" "+surname);
        Log.info("Veryfied Info at Homepage");
    }

    @Given("Click my information below the name at the menu")
    public void click_my_information_below_the_name_at_the_menu() {
        clickMyInformation();
        Log.info("Opened the My information page");
    }

    @Given("Verify this iformations with the data used during registiration")
    public void verify_this_iformations_with_the_data_used_during_registiration() {
        Assert.assertEquals(getTextInfName(),name);
        Assert.assertEquals(getTextInfSurname(),surname);
        Assert.assertTrue(getTextInfPhoneNo().contains(phoneNo));
        Log.info("Verified accuracy of data");
        Log.endTestCase("Case 1");
    }

    @Then("Verify is homepage open")
    public void verify_is_homepage_open() {
        Assert.assertEquals(mainUrl,Driver.getDriver().getCurrentUrl());
        Log.info("Verified to Open Homepage");
    }

    @Then("Login to this site and Verify for successful login")
    public void login_to_this_site_and_verify_for_successful_login() {
        loginClick();
        loginCountry(3);
        loginUername(ConfigReader.getProperty("phoneNo"));
        loginPassword(ConfigReader.getProperty("password"));
        Driver.waitFor(3);
        clickLoginBtn();
        Log.info("Login passed");
    }

    @Given("Navigate to the bottom of this site")
    public void navigate_to_the_bottom_of_this_site() {
        Driver.waitFor(2);
        navigateToBottom();
    }

    @Then("Clickability is verify in the fields under the headings -Gayrimenkul Danismanlarimiz- and -Sozlesmeler-")
    public void clickabilityIsVerifyInTheFieldsUnderTheHeadingsGayrimenkulDanismanlarimizAndSozlesmeler() {
        clickableTitle();
        Log.info("Verified to the titles are clickable");
    }

    @Then("Verify whether the texts of the h1 tag on the redirected pages are the same as the previous page")
    public void verify_whether_the_texts_of_the_h1_tag_on_the_redirected_pages_are_the_same_as_the_previous_page() {
        verifyTitle();
        Log.info("Verified to the titles text");
        Log.endTestCase("Case 2");
    }



}
