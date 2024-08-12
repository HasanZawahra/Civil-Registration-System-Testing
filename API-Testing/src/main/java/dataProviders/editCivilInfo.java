package dataProviders;

import commons.BaseTest;
import commons.PostData;
import org.testng.annotations.DataProvider;

public class editCivilInfo {

    public static PostData POST_DATA =  new PostData("sami", "ahmad", String.valueOf(BaseTest.lastID+1), "25", "0599112233");
    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][]
                {{
                    new PostData("smi", "ahmaaad", String.valueOf(BaseTest.lastID), "225", "12349")}};
    }

    @DataProvider(name = "IdNotFound")
    public Object[][] createData1() {
        return new Object[][] {{
            new PostData("smi", "ahmaaad", String.valueOf(BaseTest.lastID+3), "225", "12349"),
                "Civil Does Not Exist"
        }};
    }

    @DataProvider(name = "emptyFirstName")
    public Object[][] createData2() {
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

//    @DataProvider(name = "emptyId")
//    public Object[][] createData6() {
//        return new Object[][] {{
//                PostData.builder()
//                        .Age("25")
//                        .Mobile("0599112233")
//                        .LastName("ahmad")
//                        .FirstName("sami")
//                        .build(),
//                "Missing ID"
//        }};
//    }
}
