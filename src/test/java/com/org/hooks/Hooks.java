package com.org.hooks;

import com.PatientProfile;
import com.SharedTestContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.constants.EndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.org.utils.ApiConfig.getRequestSpecification;
import static com.org.utils.ApiConfig.getResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Hooks {

    PatientProfile profile;


    @Before(order = 1)
    public void loadUserData() throws IOException, InterruptedException {
        profile = new ObjectMapper().readValue(new File("src/test/resources/testData/signup_withoutHN_patient_profile.json"), PatientProfile.class);
        SharedTestContext.setPatientProfile(profile);
        SharedTestContext.setAdminToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkpZaEFjVFBNWl9MWDZEQmxPV1E3SG4wTmVYRSJ9.eyJhdWQiOiI1YWJhNDIzOC0xZTVmLTRhMTgtOWYyOS0yMGNmN2Q3MjA2NjciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vYzcxNzc0NmEtZjA5OS00NDlmLWFmYjEtNzU0NTYxMTQwNGIyL3YyLjAiLCJpYXQiOjE3NTQ4NzM3MzUsIm5iZiI6MTc1NDg3MzczNSwiZXhwIjoxNzU0ODc3NjYzLCJhY2N0IjowLCJhaW8iOiJBVVFBdS84WkFBQUFKODcySHNHKzFmMWdKZ2FQbW8zeE9KajVTd3V4L1RKVmIxWkVnSlFZaEtsUjNQTEQyem5xcU8rL2VjcStCcGx4b0tGN0Raa0JaSVR2R25uTzNNQXFBUT09IiwiYXV0aF90aW1lIjoxNzU0ODc0MDMzLCJhenAiOiI1YWJhNDIzOC0xZTVmLTRhMTgtOWYyOS0yMGNmN2Q3MjA2NjciLCJhenBhY3IiOiIwIiwiZW1haWwiOiJnLnNhaGFAZnZob3NwaXRhbC5jb20iLCJmYW1pbHlfbmFtZSI6IlNhaGEiLCJnaXZlbl9uYW1lIjoiR2F1cmF2IiwiaXBhZGRyIjoiMTAzLjI0OS4zOS4xMzQiLCJuYW1lIjoiR2F1cmF2IFNhaGEiLCJvaWQiOiJkN2JiZDZhYS0zOTE0LTQ3MGMtOTU2YS04ODRmZmZjMWZjNDIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJnLnNhaGFAZnZob3NwaXRhbC5jb20iLCJyaCI6IjEuQVZVQWFuUVh4NW53bjBTdnNYVkZZUlFFc2poQ3VscGZIaGhLbnlrZ3ozMXlCbWN5QVZ4VkFBLiIsInNjcCI6ImZ2LnNlcnZpY2UucmVhZCZ3cml0ZSIsInNpZCI6IjAwN2JjNzk5LTU3MmMtMGU1ZC1mNjQyLWZiODIxYWRiNWM0MCIsInN1YiI6InRJYWQyczU5Ql9McFhwNEdVTXY4U2tRNnJteHhuRm5aeHBpQnhZa0dtQlkiLCJ0aWQiOiJjNzE3NzQ2YS1mMDk5LTQ0OWYtYWZiMS03NTQ1NjExNDA0YjIiLCJ1dGkiOiJWcDZ3eDJxcFBFNlg2bFQ0LUFtTUFBIiwidmVyIjoiMi4wIiwieG1zX2Z0ZCI6IlVmZTBfQkdsT0Q2S2cwTjF4azBJUDg1ZHUxbU42MGpLRlpIVmFoRVpZWm9CYTI5eVpXRnpiM1YwYUMxa2MyMXoifQ.PfyBYs77yv8ZaCERHMXCOeir_fZrER_DVHJsKNh0_uuqxs3AqNjY7OKVGUBBV2QCej1QYQFpmMug0CgrUhK7Cu20rZr6eY8_BggrB10eWE_JDtr8lOYRygldj3hAUIJlyhr9RS2aYlJKSI2UK088z3OXZtfjQzt1hGHCOJlYPn0tZUTR5bVersAGvQZKgo09iWHjUbHPdr9yjyizOk-Fo5fjZWL7ytD1472saBM3fs8ugFaCdUkaUf-MtzzxLoIhU34Rf1VYXCXZTIfQxR8yWDeXwQE5xgCRO0PbiaYx1D5EZ8WPxoWTY0OaAHvbF3MbW0SA8-bXIC8bVRWQW6Z1kA");
//        System.out.println("Data loaded to PatientProfile object with phone number: " + profile.getPhoneNumber());
//        loginToFVCMD();

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
        } catch (Exception e) {
            System.out.println(e);
        }

        if (preCheckResponse.getStatusCode() == 400) {
            System.out.println("--------------------------------------Invoking login request--------------------------------------");
            login(profile);
            System.out.println("--------------------------------------Logged in--------------------------------------");
        } else if (preCheckResponse.getStatusCode() == 200) {
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
        } else {
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

    public void loginToFVCMD() throws InterruptedException {
        System.out.println("Launching the browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://myclnq.co/stage/fv-cmd/");

            // Verify page title
            assertEquals("FV Hospital - Command Center", driver.getTitle());

            // Verify visibility of elements
            verifyElementVisibility(driver, explicitWait, "//img[@class='welcome-logo']");
            verifyElementVisibility(driver, explicitWait, "//img[@alt='patient']");

            // Verify welcome description
            assertEquals(
                    "Log in to access your account and continue your experience with us",
                    driver.findElement(By.xpath("//p[@class='welcome-description']")).getText());

            // Perform login
            performLogin(driver, explicitWait);

            // Switch to main window and maximize
            switchToMainWindow(driver);

//            Thread.sleep(2500);
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            String token = (String) js.executeScript("return window.localStorage;");
//            System.out.println("FV CMD token ----------------------------------->" + token);
//            SharedTestContext.setAdminToken(token);
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

    public static void verifyElementVisibility(WebDriver driver, WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
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
        driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("*****");
        driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@role='heading']"), "Enter password"));
        driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("*****");
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
