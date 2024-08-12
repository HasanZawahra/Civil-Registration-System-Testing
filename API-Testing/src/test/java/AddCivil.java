import com.google.gson.Gson;
import commons.BaseTest;
import commons.Utility;
import commons.PostData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddCivil extends Utility {

    @Test(dataProvider = "successful", dataProviderClass = dataProviders.addCivilData.class, groups = {"addCivil"})
    public void successfulAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("CREATED")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "existingId", dataProviderClass = dataProviders.addCivilData.class, groups = {"all"})
    public void existingIdAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("NOT_FOUND")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyFirstName", dataProviderClass = dataProviders.addCivilData.class, groups = {"all"})
    public void emptyFirstNameAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyLastName", dataProviderClass = dataProviders.addCivilData.class, groups = {"all"})
    public void emptyLastNameAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyAge", dataProviderClass = dataProviders.addCivilData.class, groups = {"all"})
    public void emptyAgeAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyMobile", dataProviderClass = dataProviders.addCivilData.class, groups = {"all"})
    public void emptyMobileAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyId", dataProviderClass = dataProviders.addCivilData.class, groups = {"all"})
    public void emptyIdAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @AfterMethod(onlyForGroups = {"addCivil"})
    public void tearDownSuccessfulAdd() {
        RestAssured.given().contentType(ContentType.JSON)
                .when()
                .delete(prop.getProperty("base-url-delete") + String.valueOf(BaseTest.lastID))
                .then()
                .statusCode(Integer.parseInt(prop.getProperty("NO_CONTENT")));
        BaseTest.lastID = BaseTest.copy;

    }

    @AfterMethod(onlyForGroups = {"all"})
    public void tearDown() {
        BaseTest.lastID = BaseTest.copy;
    }


}