import com.google.gson.Gson;
import commons.BaseTest;
import commons.Utility;
import dataProviders.deleteCivil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteCivil extends Utility {

    @BeforeMethod(onlyForGroups = "delete")
    public void setUp() {
        String jsonPayload = new Gson().toJson(deleteCivil.POST_DATA);
        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("CREATED")));
    }

    @Test(dataProvider = "successful", dataProviderClass = deleteCivil.class, groups = "delete")
    public void testDeleteCivil(String id, String message) {
        Response response = RestAssured.delete(prop.getProperty("base-url-delete") + id);
        response
                .then()
                .assertThat()
                .statusCode(Integer.parseInt(prop.getProperty("NO_CONTENT")));
        Assert.assertTrue(response.getBody().asString().contains(message));
    }

    @Test(dataProvider = "CivilNotFound", dataProviderClass = deleteCivil.class)
    public void testDeleteCivilNotFound(String id, String message) {
        Response response = RestAssured.delete(prop.getProperty("base-url-delete") + id);
        response
                .then()
                .assertThat()
                .statusCode(Integer.parseInt(prop.getProperty("NOT_FOUND")));
        Assert.assertTrue(response.getBody().asString().contains(message));
    }

    @AfterMethod()
    public void tearDown() {
        BaseTest.lastID = BaseTest.copy;
    }
}