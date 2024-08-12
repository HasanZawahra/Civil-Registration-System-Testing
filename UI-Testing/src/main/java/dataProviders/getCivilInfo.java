package dataProviders;

import org.testng.annotations.DataProvider;

public class getCivilInfo {

    @DataProvider(name = "successful")
    public Object[][] createData() {
        return new Object[][] {{"1", "First Name: ahmad\n" +
                "Last Name: mousa\n" +
                "ID:  1\n" +
                "Age:  31\n" +
                "Mobile Number: 0598541236"}};
    }

    @DataProvider(name = "empty")
    public Object[] createData2() {
        return new Object[] {"Could not find civil with ID : "};
    }

    public static String buildSucessfulMessage(String id, String firstName, String lastName, String age, String mobile) {
        return "First Name: "+firstName+"\n" +
                "Last Name: "+lastName+"\n" +
                "ID:  "+id+"\n" +
                "Age:  "+age+"\n" +
                "Mobile Number: "+mobile;
    }

    public static String buildNotFountMessage(String id) {
        return "Could not find civil with ID : " + id;
    }
}
