package dataProviders;

import org.testng.annotations.DataProvider;

public class deleteCivil {

    public static String FIRST_NAME = "sami";
    public static String LAST_NAME = "ahmad";
    public static String AGE = "25";
    public static String MOBILE = "123456789";

    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][] {{"Civil has been deleted successfully"}};
    }

    @DataProvider(name = "emptyId")
    public Object[][] createData2() {
        return new Object[][] {{ "Could not find civil with ID : "}};
    }

    public static String buildSuccessMessage(String s){
        return "First Name: sami\n" +
                "Last Name: ahmad\n" +
                "ID:  "+s+"\n" +
                "Age:  25\n" +
                "Mobile Number: 123456789";
    }

    public static String idNotFoundMessage(String s){
        return "Could not find civil with ID : "+s;
    }
}
