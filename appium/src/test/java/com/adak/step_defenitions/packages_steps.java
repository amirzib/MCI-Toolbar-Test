package com.adak.step_defenitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class packages_steps{

    public AndroidDriver driver;
    public UiAutomator2Options options;
    
    @SuppressWarnings("deprecation")
    @Given("I open the app")
    public void i_open_the_app() throws MalformedURLException{
    // connecting to appium server programatically
    // service = new AppiumServiceBuilder()
    // .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
    // .withIPAddress("127.0.0.1")
    // .usingPort(4723)
    // .build();

    // service.start();

    //initionalizing uiAutomator for real device and set 'mymci' as base app
    options = new UiAutomator2Options()
    .setPlatformName("Android")
    .setPlatformVersion("13")
    // .setAppPackage("ir.mci.ecareapp")
    // .setAppActivity("ir.mci.ecareapp.ui.activity.LauncherActivity")
    // .setUdid("WGOZ95NN8PLF6DUK")
    // .setUdid("RF8W201TDWB")
    // .setUdid("ALG1B00001780518225")
    // .setApp("//Users//qtroom//Desktop//appium-java-zib//appium//src//main//resources//mymci.apk")
    .setAutoGrantPermissions(true)
    // .setAutomationName("uiautomator2")
    .setNoReset(true);

    //initionalizing android driver
    driver = new AndroidDriver(
    new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.accessibilityId("My-MCI")).click();
    }

    @When("I click on packages on toolbar")
    public void i_click_on_packages_on_toolbar(){
        driver.findElement(By.id("ir.mci.ecareapp:id/packages_fragment")).click();
    }
    
    @When("I click on buy new package")
    public void i_click_on_buy_new_package(){
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_package_btn_packages_fragment")).click();
    }

    @When("I click on internet")
    public void i_click_on_internet(){
        driver.findElement(AppiumBy.accessibilityId("اینترنت")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/internet_packages_rv_buy_internet_package_fragment")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_internet_iv")).click();
    }

    @When("I click on conversation")
    public void i_click_on_conversation(){
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_package_btn_packages_fragment")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='مکالمه']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/conversation_packages_rv_conversation_packages_fragment")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_conversation_iv")).click();
    }

    @When("I click on mci")
    public void i_click_on_mci(){
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_package_btn_packages_fragment")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='همراهی']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/net_incentive_rv")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/call_indicator_cv_buy_hamrahi_packages_fragment")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/incentive_call_packages_rv")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/sms_indicator_cv_buy_hamrahi_packages_fragment")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/sms_incentive_rv")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_internet_iv")).click();
    }

    @When("I click on hybrid")
    public void i_click_on_hybrid(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='ترکیبی']")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/rules_btn_rules_layout")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/rules_webview")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_iv_rules_bottom_sheet")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/desired_package_cost_tv_desired_packages_fragment")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_desired_iv")).click();
    }
    
    @When("I click on sms")
    public void i_click_on_sms(){
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_package_btn_packages_fragment")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='پیامک']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/packages_rv_buy_dynamic_package")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_internet_iv")).click();
    }

    @When("I click on international")               
    public void i_click_on_international(){
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_package_btn_packages_fragment")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='بین الملل']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/packages_rv_buy_dynamic_package")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_internet_iv")).click();
    }

    @When("I click on roming")
    public void i_click_on_roming(){
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_package_btn_packages_fragment")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='رومینگ']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/packages_rv_buy_dynamic_package")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottomsheet_internet_iv")).click();
    }
      
    @Then("everything should work correctly")
    public void everything_should_work_correctly(){
        driver.findElement(AppiumBy.accessibilityId("خانه")).click();
        driver.terminateApp("ir.mci.ecareapp");
        driver.quit();
    }





    @When("I click on charge on toolbar")
    public void i_click_on_charge_on_toolbar() {
        driver.findElement(AppiumBy.accessibilityId("شارژ")).click();
    }
    @When("I click on extraordinary details")
    public void i_click_on_extraordinary_details() {
        driver.findElements(By.id("ir.mci.ecareapp:id/details_tv_charge_remains_item_adapter")).get(0).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/ok_btn_rules_bottom_sheet")).click();
    }
    @When("I click on loyality details")
    public void i_click_on_loyality_details() {
        driver.findElements(By.id("ir.mci.ecareapp:id/details_tv_charge_remains_item_adapter")).get(1).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/ok_btn_rules_bottom_sheet")).click();
    }
    @When("I click on ladyes details")
    public void i_click_on_ladyes_details() {
        driver.findElements(By.id("ir.mci.ecareapp:id/details_tv_charge_remains_item_adapter")).get(2).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/ok_btn_rules_bottom_sheet")).click();
    }
    @When("I click on buy new charge")
    public void i_click_on_buy_new_charge() {
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_charge_btn_charge_remains_fragment")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/price_rv_new_charge_fragment")).isDisplayed());
    }
    @When("I click on extraordinary")
    public void i_click_on_extraordinary() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='فوق العاده']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/price_rv_new_charge_fragment")).isDisplayed());
    }
    @When("I click on ladyes")
    public void i_click_on_ladyes() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='بانوان']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/price_rv_new_charge_fragment")).isDisplayed());
    }
    @When("I click on teens")
    public void i_click_on_teens() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='جوانان']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/price_rv_new_charge_fragment")).isDisplayed());
    }
    @When("I click on loyality")
    public void i_click_on_loyality() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView(text(\"وفاداری\"))"));
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
        ".scrollIntoView(new UiSelector().text(\"وفاداری\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='وفاداری']")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/price_rv_new_charge_fragment")).isDisplayed());
    }
    @When("I click on buy")
    public void i_click_on_buy() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='شارژ عادی']")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/buy_charge_btn_new_charge_fragment")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/wallet_toggle_choosing_type_of_payment")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/purchase_amount_to_pay_tv_choosing_type_of_payment")).isDisplayed());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottom_sheet_choosing_type_of_payment_fragment")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/close_charge_buy_fragment")).click();

    }
    @When("I click on parachute")
    public void i_click_on_parachute() {
        driver.findElement(AppiumBy.accessibilityId("چتر اضطراری")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/rules_btn_rules_layout")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/close_iv_rules_bottom_sheet")).click();
    }



    @When("I click on wallet on toolbar")
    public void i_click_on_wallet_on_toolbar(){
        driver.findElement(AppiumBy.accessibilityId("کیف پول")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/wallet_amount_hint_tv_wallet_fragment")).isDisplayed());

    }

    @When("I click on increase balance")
    public void i_click_on_increase_balance(){
        driver.findElement(By.id("ir.mci.ecareapp:id/increase_balance_btn_wallet_fragment")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/five_thousands_btn_charge_wallet_fragment")).click();
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/increase_wallet_btn_charge_wallet_fragment")).isEnabled());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_bottom_sheet_charge_wallet_fragment")).click();
    }


    @When("I click on cash out")
    public void i_click_on_cash_out(){
        driver.findElement(By.id("ir.mci.ecareapp:id/cash_out_btn_wallet_fragment")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/cart_number_et_cash_out_bottom_sheet")).sendKeys("5022 2913 1760 1100");
        driver.findElement(By.id("ir.mci.ecareapp:id/amount_et_cash_out_bottom_sheet")).sendKeys("50000");
        Assert.assertTrue(driver.findElement(By.id("ir.mci.ecareapp:id/confirm_btn_cash_out_bottom_sheet")).isEnabled());
        driver.findElement(By.id("ir.mci.ecareapp:id/close_iv_cash_out_bottom_sheet")).click();
    }

    @When("I click on all transactions")
    public void i_click_on_all_transactions(){
        driver.findElement(By.id("ir.mci.ecareapp:id/all_transactions_tv_wallet_fragment")).click();
        driver.findElement(By.id("ir.mci.ecareapp:id/toolbar_back_iv")).click();
    }

}