import dataProviders.deleteCivil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ManagementPage;

public class DeleteCivil extends BaseTest{

    @BeforeMethod(onlyForGroups = {"deleteCivil"})
    public void beforeMethod() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID++;
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(deleteCivil.FIRST_NAME);
        managementPage.setLastNameField(deleteCivil.LAST_NAME);
        managementPage.setAgeField(deleteCivil.AGE);
        managementPage.setMobileField(deleteCivil.MOBILE);
        managementPage.clickDoneButton();
    }

    @Test(groups = {"deleteCivil"}, dataProvider = "successful", dataProviderClass = deleteCivil.class)
    public void test_deleteCivilSuccessful(String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), deleteCivil.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickDeleteCivilButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test
    public void test_deleteCivilIdNotFound() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        managementPage.clickDeleteCivilButton();
        Assert.assertEquals(managementPage.getMessage(), deleteCivil.idNotFoundMessage(String.valueOf(lastID+1)));
    }

    @Test(dataProvider = "emptyId", dataProviderClass = deleteCivil.class)
    public void test_deleteCivilEmptyId(String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickDeleteCivilButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @AfterMethod
    public void clear() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clearAll();
    }
}
