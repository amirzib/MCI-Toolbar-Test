package com.adak.step_defenitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class login_steps {


    public AndroidDriver driver;
    public UiAutomator2Options options;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private ObjectMapper objectMapper;
    private JsonNode jsonNode;
    private String baseUrl = "http://192.168.2.112:8090/api/v1/%s";
    private String number ;
    private AppiumDriverLocalService service;
    
    @SuppressWarnings("deprecation")
    @Before
    public void configureAppium() throws MalformedURLException{

    //connecting to appium server programatically
    service = new AppiumServiceBuilder()
    .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
    .withIPAddress("127.0.0.1")
    .usingPort(4723)
    .build();

    service.start();

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
    }

    @Given("I start the app")
    public void i_start_the_app() throws MalformedURLException, InterruptedException{
        driver.findElement(AppiumBy.accessibilityId("My-MCI")).click();
        // driver.activateApp("ir.mci.ecareapp");
    }
    

    @When("I skip the intro")
    public void i_skip_the_intro() {
        // for(int i=0 ;i<=3 ;i++){
        //     driver.findElement(By.id("next_fragment_tv_intro_activity")).click();
        // }
        // driver.findElement(By.id("finish_tv_intro_activity")).click();
    }

    @When("I enter my number and click on step code")
    public void i_enter_my_number_and_click_on_step_code() throws IOException, InterruptedException{
        String assignBodyTemplate = "{\"operator\": \"%s\", \"simType\": \"%s\", \"appName\": \"%s\"}";
        client = HttpClient.newBuilder().build();
        request = HttpRequest.newBuilder()
            .uri(URI.create(String.format(baseUrl, "assign")))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(String.format(assignBodyTemplate, "MCI", "CREDIT", "MY_MCI")))
            .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(response.body());
        number = jsonNode.get("number").asText();
        driver.findElement(By.id("ir.mci.ecareapp:id/phone_number_edt")).sendKeys(jsonNode.get("number").asText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button"))
        .click();
    }

    @When("I enter the vertification code")
    public void i_enter_the_vertification_code() throws IOException, InterruptedException{
        // driver.findElement(By.id("ir.mci.ecareapp:id/login_btn_login_fragment")).click();
        request = HttpRequest.newBuilder()
            .uri(URI.create(String.format(baseUrl, "watch?token=" + jsonNode.get("token").asText())))
            .header("Content-Type", "application/json")
            .GET()
            .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(response.body());
        String code = jsonNode.get("code").asText();
        driver.findElement(By.id("ir.mci.ecareapp:id/verify_et_activation_code_activity")).sendKeys(code);

    }

    // @SuppressWarnings("deprecation")
    @When("I skip biometric and tutorial")
    public void i_skip_biometric_and_tutorial(){
        //Skip biometric and tutorial
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.findElement(By.id("ir.mci.ecareapp:id/deny_btn_soft_bio_metric")).click();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.findElement(By.id("ir.mci.ecareapp:id/tv_skip")).click();
    }

    @Then("I should be in main app page")
    public void i_should_be_in_main_app_page() throws InterruptedException  {
        Thread.sleep(5000);
        String getNumber =driver.findElement(By.id("ir.mci.ecareapp:id/active_phone_number_tv")).getText();
        Assert.assertTrue(getNumber.equals(number));
    }

   @After
    public void tearDown(){
        //stop service and quit driver after all
        // driver.terminateApp("ir.mci.ecareapp");
        // driver.quit();
    }
}