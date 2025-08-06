package hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import models.PatientProfile;
import models.TestDataStore;


import java.io.File;
import java.io.IOException;

public class GlobalHooks {
    private final TestDataStore dataStore;

    public GlobalHooks(TestDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Before(order = 0)
    public void loadTestData() {
        PatientProfile profile = loadJson("src/test/resources/testdata/patient_profile.json");
        dataStore.setPatientProfile(profile);
        System.out.println("GlobalHooks.loadTestData() invoked");
    }

    private PatientProfile loadJson(String path) {
        try {
            return new ObjectMapper().readValue(new File(path), PatientProfile.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON from " + path, e);
        }
    }
}
