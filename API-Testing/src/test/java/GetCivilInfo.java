import commons.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCivilInfo extends Utility {

    @Test(dataProvider = "successful", dataProviderClass = dataProviders.getCivilInfo.class)
    public void getCivilInfo(String id, String message) {
        Response response = RestAssured.get(prop.getProperty("base-url-get")+id);
        System.out.println(id);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode), prop.getProperty("OK"));
        String s = response.getBody().asString();
        Assert.assertEquals(s, message);
    }

    @Test(dataProvider = "CivilNotFound", dataProviderClass = dataProviders.getCivilInfo.class)
    public void getCivilInfo1(String id, String message) {
        Response response = RestAssured.get(prop.getProperty("base-url-get")+id);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode), prop.getProperty("NOT_FOUND"));
        String s = response.getBody().asString();
        Assert.assertEquals(s, message);
    }
}
