package dataProviders;

import commons.BaseTest;
import org.testng.annotations.DataProvider;

public class getCivilInfo {

    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][] {{String.valueOf(BaseTest.copy), "{\"FirstName\":\""+BaseTest.arr[0]+"\",\"LastName\":\""+BaseTest.arr[1]+"\",\"ID\":\""+String.valueOf(BaseTest.copy)+"\",\"Age\":\""+BaseTest.arr[3]+"\",\"Mobile\":\""+BaseTest.arr[4]+"\"}"
        }};
    }

    @DataProvider(name = "CivilNotFound")
    public Object[][] createData1() {
        return new Object[][] {{String.valueOf(BaseTest.copy+1), "Not Found"}};
    }
}
