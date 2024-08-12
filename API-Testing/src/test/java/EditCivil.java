import com.google.gson.Gson;
import commons.BaseTest;
import commons.Utility;
import commons.PostData;
import dataProviders.deleteCivil;
import dataProviders.editCivilInfo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

public class EditCivil extends Utility {

    @BeforeClass
    public void setUp() {
        String jsonPayload = new Gson().toJson(editCivilInfo.POST_DATA);
        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post(prop.getProperty("base-url-add"));
//        System.out.println(editCivilInfo.POST_DATA.getID());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("CREATED")));
    }

    @Test(dataProvider = "successful", dataProviderClass = dataProviders.editCivilInfo.class, groups = {"editCivil"})
    public void successfulAddCivil(PostData postData) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put(prop.getProperty("base-url-edit"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("OK")));
        Assert.assertTrue(response.getBody().asString().contains(jsonPayload.toString()));
    }

    @Test(dataProvider = "IdNotFound", dataProviderClass = dataProviders.editCivilInfo.class, groups = {"editCivil"})
    public void existingIdAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);
        System.out.println(postData.getID());
        BaseTest.lastID = BaseTest.copy+=1;
        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put(prop.getProperty("base-url-edit"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("NOT_FOUND")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyFirstName", dataProviderClass = dataProviders.editCivilInfo.class, groups = {"editCivil"})
    public void emptyFirstNameAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put(prop.getProperty("base-url-edit"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyLastName", dataProviderClass = dataProviders.editCivilInfo.class, groups = {"editCivil"})
    public void emptyLastNameAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put(prop.getProperty("base-url-edit"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyAge", dataProviderClass = dataProviders.editCivilInfo.class, groups = {"editCivil"})
    public void emptyAgeAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put(prop.getProperty("base-url-edit"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

    @Test(dataProvider = "emptyMobile", dataProviderClass = dataProviders.editCivilInfo.class, groups = {"editCivil"})
    public void emptyMobileAddCivil(PostData postData, String message) {
        String jsonPayload = new Gson().toJson(postData);

        final Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put(prop.getProperty("base-url-edit"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
        Assert.assertEquals(response.getBody().asString(), message);
    }

////    @Test(dataProvider = "emptyId", dataProviderClass = dataProviders.editCivilInfo.class)
////    public void emptyIdAddCivil(PostData postData, String message) {
////        String jsonPayload = new Gson().toJson(postData);
////
////        final Response response = RestAssured.given().contentType(ContentType.JSON)
////                .body(jsonPayload)
////                .when()
////                .put(prop.getProperty("base-url-edit"));
////
////        int statusCode = response.getStatusCode();
////        Assert.assertEquals(statusCode, Integer.parseInt(prop.getProperty("BAD_REQUEST")));
////        Assert.assertEquals(response.getBody().asString(), message);
////    }
//
    @AfterClass
    public void tearDownSuccessfulAdd() {
        RestAssured.given().contentType(ContentType.JSON)
                .when()
                .delete(prop.getProperty("base-url-delete") + String.valueOf(BaseTest.lastID))
                .then()
                .statusCode(Integer.parseInt(prop.getProperty("NO_CONTENT")));
        BaseTest.lastID = BaseTest.copy-1;
        BaseTest.copy--;
    }
}
