package dataProviders;

import org.testng.annotations.DataProvider;

public class addCivilData {

    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][] {{"sami", "ahmad", "25", "123456789", "Civil has been added successfully"}};
    }

    @DataProvider(name = "existingId")
    public Object[][] createData1() {
        return new Object[][] {{"sami", "ahmad", "25", "123456789"}};
    }

    @DataProvider(name = "emptyFields")
    public Object[][] createData2() {
        return new Object[][] {{"sami", "ahmad", "25", "123456789", "Invalid Request"}};
    }

    public static String buildFailedMessage(String id) {
        return "Failed to add used with ID : " + id;
    }
}
