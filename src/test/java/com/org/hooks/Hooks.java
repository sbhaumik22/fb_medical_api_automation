package com.org.hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.constants.EndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import com.PatientProfile;
import com.SharedTestContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static com.org.utils.ApiConfig.getRequestSpecification;
import static com.org.utils.ApiConfig.getResponseSpecification;

public class Hooks {

    PatientProfile profile;


    @Before(order = 1)
    public void loadUserData() throws IOException {
        profile = new ObjectMapper().readValue(new File("src/test/resources/testData/signup_withoutHN_patient_profile.json"), PatientProfile.class);
        SharedTestContext.setPatientProfile(profile);
//        System.out.println("Data loaded to PatientProfile object with phone number: " + profile.getPhoneNumber());


    }

    @Before("@requireUser")
    public void setupUser() throws IOException {
        String preCheckPath = EndPoints.USER_SIGN_UP_PRE_CHECK.getPath();
        Response preCheckResponse = given()
                .spec(getRequestSpecification())
                .body(profile)
                .when().post(preCheckPath)
                .then().extract().response();

        System.out.println("--------------------------------------Sign up pre check is done--------------------------------------");
        System.out.println("Status code: " + preCheckResponse.getStatusCode());
        try {
            System.out.println("Message: " + preCheckResponse.jsonPath().getString("message"));
        }
        catch (Exception e){
            System.out.println(e);
        }

        if (preCheckResponse.getStatusCode() == 400) {
            System.out.println("--------------------------------------Invoking login request--------------------------------------");
            login(profile);
            System.out.println("--------------------------------------Logged in--------------------------------------");
        } else if (preCheckResponse.getStatusCode() == 200){
            System.out.println("--------------------------------------No active account found! Invoking Sign up request--------------------------------------");
            Response signUpResponse = given()
                    .spec(getRequestSpecification())
                    .body(profile)
                    .when().post(EndPoints.USER_SIGN_UP.getPath())
                    .then().spec(getResponseSpecification())
                    .extract().response();

            SharedTestContext.setUserToken(signUpResponse.jsonPath().getString("data.token"));
            SharedTestContext.setUserId(signUpResponse.jsonPath().getString("data.user._id"));
            System.out.println("--------------------------------------Signed up, New user created--------------------------------------");
        }
        else {
            System.out.println("--------------------------Unknown Error--------------------------");
        }
    }

    private void login(PatientProfile profile) {
        Response loginResponse = given()
                .spec(getRequestSpecification())
                .body(profile)
                .when().post(EndPoints.USER_LOGIN.getPath())
                .then().spec(getResponseSpecification())
                .extract().response();

        SharedTestContext.setUserToken(loginResponse.jsonPath().getString("data.token"));
        SharedTestContext.setUserId(loginResponse.jsonPath().getString("data.user._id"));
    }

    public void loginToFVCMD() {
        System.out.println("Launching the browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://myclnq.co/stage/fv-cmd/");

            // Verify page title
            Assertions.assertEquals("FV Hospital - Command Center", driver.getTitle());

            // Verify visibility of elements
            AppTest appTest = new AppTest();
            appTest.verifyElementVisibility(driver, explicitWait, "//img[@class='welcome-logo']");
            appTest.verifyElementVisibility(driver, explicitWait, "//img[@alt='patient']");

            // Verify language options
            List<String> expectedLangOptions = List.of("Vietnamese", "English");
            driver.findElement(By.xpath("//div[@class='sel-dropdown lng']")).click();
            List<WebElement> langContainer = driver.findElements(By.xpath("//div[@class='sel-dropdown lng']//li"));
            List<String> actualLangOptions = new ArrayList<>();
            for (WebElement langOption : langContainer) {
                actualLangOptions.add(langOption.getText());
            }
            Assertions.assertEquals(expectedLangOptions, actualLangOptions);

            // Verify welcome description
            Assertions.assertEquals(
                    "Log in to access your account and continue your experience with us",
                    driver.findElement(By.xpath("//p[@class='welcome-description']")).getText());

            // Perform login
            performLogin(driver, explicitWait);

            // Switch to main window and maximize
            switchToMainWindow(driver);
            driver.manage().window().maximize();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

    public void verifyElementVisibility(WebDriver driver, WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        Assertions.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    private static void performLogin(WebDriver driver, WebDriverWait wait) {
        driver.findElement(By.className("welcome-microsoft")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='welcome-login']")));
        driver.findElement(By.xpath("//div[@class='welcome-login']")).click();

        Set<String> windowsIDs = driver.getWindowHandles();
        List<String> windowIDList = new ArrayList<>(windowsIDs);
        for (String winHandle : windowIDList) {
            driver.switchTo().window(winHandle);
            if (driver.getTitle() != null && driver.getTitle().contains("Sign in to your account")) {
                break;
            }
        }

        // Perform login steps
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@role='heading']"), "Sign in"));
        driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("g.saha@fvhospital.com");
        driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@role='heading']"), "Enter password"));
        driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("8LyPLqge");
        driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@role='heading']"), "Stay signed in?"));
        driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
    }

    private static void switchToMainWindow(WebDriver driver) {
        String mainWindowID = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(mainWindowID);
    }

    @After("@cleanUp")
    public void tearDown() {
        String deletePath = EndPoints.USER_DELETE.getPath();
        System.out.println(SharedTestContext.getUserToken());
        System.out.println("--------------------------------------Invoking delete request--------------------------------------");
        Response deleteResponse = given()
                .header("Authorization", "Bearer " + SharedTestContext.getUserToken())
                .spec(getRequestSpecification())
                .when().delete(deletePath)
                .then().spec(getResponseSpecification())
                .extract().response();
        System.out.println("--------------------------------------Account deleted, Clean up done--------------------------------------");
    }
}
