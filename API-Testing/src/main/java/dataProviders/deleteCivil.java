package dataProviders;

import commons.PostData;
import org.testng.annotations.DataProvider;
import commons.BaseTest;

public class deleteCivil {

    public static PostData POST_DATA =  new PostData("sami", "ahmad", String.valueOf(BaseTest.lastID+=1), "25", "0599112233");
    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][] {{String.valueOf(BaseTest.lastID), "" }};
    }

    @DataProvider(name = "CivilNotFound")
    public Object[][] createData1() {
        return new Object[][] {{String.valueOf(BaseTest.lastID+=1), "Not Found"}};
    }
}
