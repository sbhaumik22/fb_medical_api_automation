package Utility;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class TestDataFactory {
    private static final Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getStrongPassword() {
        return faker.internet().password(10, 16, true, true);
    }

    public static Map<String, Object> getSignupPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", getFirstName());
        payload.put("lastname", getLastName());
        payload.put("email", getRandomEmail());
        payload.put("password", getStrongPassword());
        return payload;
    }
}
