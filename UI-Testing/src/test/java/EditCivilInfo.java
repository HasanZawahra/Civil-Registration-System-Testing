import dataProviders.editCivilInfo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ManagementPage;

public class EditCivilInfo extends BaseTest{

    @BeforeMethod(onlyForGroups = {"editCivilInfo"})
    public void beforeMethod() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        lastID+=1;
//        System.out.println(lastID);
        managementPage.clickAddCivilButton();
        managementPage.setFirstNameField(editCivilInfo.FIRST_NAME);
        managementPage.setLastNameField(editCivilInfo.LAST_NAME);
        managementPage.setAgeField(editCivilInfo.AGE);
        managementPage.setMobileField(editCivilInfo.MOBILE);
        managementPage.clickDoneButton();
    }

    @Test(groups = {"editCivilInfo"}, dataProvider = "successful", dataProviderClass = editCivilInfo.class)
    public void test_editCivilInfoSuccessful(String firstName, String lastName, String age, String mobile, String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickEditCivilButton();
        managementPage.clearCivilInfo();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
        managementPage.clearCivilInfo();
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.editsuccessfullymeassage(String.valueOf(lastID)));
    }

    @Test(groups = {"X"})
    public void test_editCivilInfoIdNotFound() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setOperationsField(String.valueOf(lastID+1));
        managementPage.clickEditCivilButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildIdNotFoundMessage(String.valueOf(lastID+1)));
    }

    @Test(groups = {"X"}, dataProvider = "emptyId", dataProviderClass = editCivilInfo.class)
    public void test_editCivilInfoEmptyId(String message) {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickEditCivilButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(groups = {"editCivilInfo"}, dataProvider = "emptyFields", dataProviderClass = editCivilInfo.class)
    public void test_emptyFirstName(String firstName, String lastName, String age, String mobile, String message){
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickEditCivilButton();
        managementPage.clearCivilInfo();
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(groups = {"editCivilInfo"}, dataProvider = "emptyFields", dataProviderClass = editCivilInfo.class)
    public void test_emptyLastName(String firstName, String lastName, String age, String mobile, String message){
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickEditCivilButton();
        managementPage.clearCivilInfo();
        managementPage.setFirstNameField(firstName);
        managementPage.setAgeField(age);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(groups = {"editCivilInfo"}, dataProvider = "emptyFields", dataProviderClass = editCivilInfo.class)
    public void test_emptyAge(String firstName, String lastName, String age, String mobile, String message){
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickEditCivilButton();
        managementPage.clearCivilInfo();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setMobileField(mobile);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(groups = {"editCivilInfo"}, dataProvider = "emptyFields", dataProviderClass = editCivilInfo.class)
    public void test_emptyMobile(String firstName, String lastName, String age, String mobile, String message){
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickEditCivilButton();
        managementPage.clearCivilInfo();
        managementPage.setFirstNameField(firstName);
        managementPage.setLastNameField(lastName);
        managementPage.setAgeField(age);
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @Test(groups = {"editCivilInfo"}, dataProvider = "emptyFields", dataProviderClass = editCivilInfo.class)
    public void test_editCivilInfoEmptyFields(String firstName, String lastName, String age, String mobile, String message){
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.setCivilIDFieldGet(String.valueOf(lastID));
        managementPage.clickGetCivilInfoButton();
        Assert.assertEquals(managementPage.getMessage(), editCivilInfo.buildSuccessMessage(String.valueOf(lastID)));
        managementPage.clickEditCivilButton();
        managementPage.clearCivilInfo();
        managementPage.clickDoneButton();
        Assert.assertEquals(managementPage.getMessage(), message);
    }

    @AfterMethod(onlyForGroups = {"editCivilInfo"})
    public void deleteCivil() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickDeleteCivilButton();
        lastID = copy;
        managementPage.clearAll();
    }

    @AfterMethod(onlyForGroups = {"X"})
    public void clear(){
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clearAll();
        lastID = copy;
    }
}
