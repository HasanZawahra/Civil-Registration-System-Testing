import dataProviders.addCivilData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ManagementPage;

public class AddCivil extends BaseTest {

    @Test(dataProvider = "successful", dataProviderClass = addCivilData.class, groups = {"addCivil"})
    public void test_AddCivilSuccessful(String firstName, String lastName,
                                        String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID++;
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(dataProvider = "existingId", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_AddCivilExistingId(String firstName, String lastName, String age, String mobile) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID));
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), addCivilData.buildFailedMessage(String.valueOf(lastID)));
    }

    @Test(dataProvider = "emptyFields", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_emptyID(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(dataProvider = "emptyFields", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_emptyFirstName(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID++;
        managementPage.clickAddCivilButton();
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(dataProvider = "emptyFields", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_emptyLastName(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID++;
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(firstName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(dataProvider = "emptyFields", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_emptyAge(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID++;
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(dataProvider = "emptyFields", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_emptyMobile(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID++;
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(dataProvider = "emptyFields", dataProviderClass = addCivilData.class, groups = {"X"})
    public void test_emptyAll(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickAddCivilButton();
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @AfterMethod(onlyForGroups = "X")
    public void clear() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clearAll();
    }

    @AfterMethod(onlyForGroups = "addCivil")
    public void deleteCivil() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickDeleteCivilButton();
        managementPage.clearAll();
    }
}
