import dataProviders.getCivilInfo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ManagementPage;

public class GetCivilInfo extends BaseTest{

    @Test()
    public void test_GetCivilInfo() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), getCivilInfo.buildSucessfulMessage(
                String.valueOf(lastID), BaseTest.lastIdObject.get("FirstName"),BaseTest.lastIdObject.get("LastName"),BaseTest.lastIdObject.get("Age"),BaseTest.lastIdObject.get("MobileNumber")));
    }

    @Test
    public void test_CivilNotFound() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID+2));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), getCivilInfo.buildNotFountMessage(String.valueOf(lastID+2)));
    }

    @Test(dataProvider = "empty", dataProviderClass = getCivilInfo.class)
    public void test_GetCivilInfoEmpty(String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @AfterMethod
    public void clear() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clearAll();
    }
}
