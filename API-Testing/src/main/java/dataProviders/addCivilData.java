package dataProviders;

import commons.PostData;
import org.testng.annotations.DataProvider;
import commons.BaseTest;

public class addCivilData {

    @DataProvider(name = "successful")
    public Object[][] createData() {
        BaseTest.lastID++;
        return new Object [][] {{
                new PostData("sami", "ahmad", String.valueOf(BaseTest.lastID), "25", "0599112233"),
                "{\"FirstName\":\"sami\",\"LastName\":\"ahmad\",\"ID\":\""+String.valueOf(BaseTest.lastID)+"\",\"Age\":\"25\",\"Mobile\":\"0599112233\"}"

        }};
    }

    @DataProvider(name = "existingId")
    public Object[][] createData1() {
        return new Object[][]{{
                new PostData("sami", "ahmad", String.valueOf(BaseTest.lastID), "25", "123456789"),
                "Civil Already Exists"
                }};
    }

    @DataProvider(name = "emptyFirstName")
    public Object[][] createData2() {
        BaseTest.lastID++;
        return new Object[][] {{
                 PostData.builder()
                         .Age("25")
                         .ID(String.valueOf(BaseTest.lastID))
                         .LastName("ahmad")
                         .Mobile("0599112233")
                         .build(),
                "Missing First Name"
        }};
    }

    @DataProvider(name = "emptyLastName")
    public Object[][] createData3() {
        BaseTest.lastID++;
        return new Object[][] {{
                 PostData.builder()
                         .Age("25")
                         .ID(String.valueOf(BaseTest.lastID))
                         .FirstName("sami")
                         .Mobile("0599112233")
                         .build(),
                "Missing Last Name"
        }};
    }

    @DataProvider(name = "emptyAge")
    public Object[][] createData4() {
        BaseTest.lastID++;
        return new Object[][] {{
                 PostData.builder()
                         .FirstName("sami")
                         .ID(String.valueOf(BaseTest.lastID))
                         .LastName("ahmad")
                         .Mobile("0599112233")
                         .build(),
                "Missing Age"
        }};
    }

    @DataProvider(name = "emptyMobile")
    public Object[][] createData5() {
        BaseTest.lastID++;
        return new Object[][] {{
                 PostData.builder()
                         .Age("25")
                         .ID(String.valueOf(BaseTest.lastID))
                         .LastName("ahmad")
                         .FirstName("sami")
                         .build(),
                "Missing Mobile"
        }};
    }

    @DataProvider(name = "emptyId")
    public Object[][] createData6() {
        return new Object[][] {{
                 PostData.builder()
                         .Age("25")
                         .Mobile("0599112233")
                         .LastName("ahmad")
                         .FirstName("sami")
                         .build(),
                "Missing ID"
        }};
    }
}
