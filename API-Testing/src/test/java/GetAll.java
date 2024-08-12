import commons.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAll extends Utility {

    @Test
    public void getAll() {
        Response response = RestAssured.get(prop.getProperty("base-url"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode), prop.getProperty("OK"));
        String s = response.asString();
        Assert.assertNotEquals(s.length(), 0);
    }
}
