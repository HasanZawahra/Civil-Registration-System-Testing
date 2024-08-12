package dataProviders;

import org.testng.annotations.DataProvider;

public class editCivilInfo {

    public static String FIRST_NAME = "sami";
    public static String LAST_NAME = "ahmad";
    public static String AGE = "25";
    public static String MOBILE = "123456789";

    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][] {{"smi", "ahmaaad", "225", "12349", "Civil has been edited successfully"}};
    }

    @DataProvider(name = "emptyId")
    public Object[][] createData2() {
        return new Object[][] {{"Could not find civil with ID : "}};
    }

    @DataProvider(name = "emptyFields")
    public Object[][] createData3() {
        return new Object[][] {{ "smi", "ahmaaad", "225", "12349", "Invalid Request"}};
    }

    public static String buildSuccessMessage(String s){
        return "First Name: sami\n" +
                "Last Name: ahmad\n" +
                "ID:  "+s+"\n" +
                "Age:  25\n" +
                "Mobile Number: 123456789";
    }

    public static String editsuccessfullymeassage(String s){
        return "First Name: smi\n" +
                "Last Name: ahmaaad\n" +
                "ID:  "+s+"\n" +
                "Age:  225\n" +
                "Mobile Number: 12349";
    }

    public static String buildIdNotFoundMessage(String s){
        return "Could not find civil with ID : "+s;
    }
}
