package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementPage extends BasePage {
    public ManagementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "getAll")
    private WebElement getAllButton;

    @FindBy(id = "civilsID")
    private WebElement civilIDFieldGet;

    @FindBy(id = "civil")
    private WebElement getCivilInfoButton;

    @FindBy(id = "CivilID")
    private WebElement OperationsField;

    @FindBy(id = "editCivilBt")
    private WebElement editCivilButton;

    @FindBy(id = "deleteCivilBt")
    private WebElement deleteCivilButton;

    @FindBy(id = "addCivilBt")
    private WebElement addCivilButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Age")
    private WebElement ageField;

    @FindBy(id = "Mobile")
    private WebElement mobileField;

    @FindBy(id = "Done")
    private WebElement doneButton;

    @FindBy(id = "civilInfo")
    private WebElement message;

    public void clickGetAllButton() {
        getAllButton.click();
    }

    public void clickGetCivilInfoButton() {
        getCivilInfoButton.click();
    }

    public void clickEditCivilButton() {
        editCivilButton.click();
    }

    public void clickDeleteCivilButton() {
        deleteCivilButton.click();
    }

    public void clickAddCivilButton() {
        addCivilButton.click();
    }

    public void clickDoneButton() {
        doneButton.click();
    }

    public void setCivilIDFieldGet(String civilID) {
        civilIDFieldGet.sendKeys(civilID);
    }

    public void setOperationsField(String operation) {
        OperationsField.sendKeys(operation);
    }

    public void setFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setAgeField(String age) {
        ageField.sendKeys(age);
    }

    public void setMobileField(String mobile) {
        mobileField.sendKeys(mobile);
    }

    public String getMessage() {
        return message.getText();
    }

    public void clearAll() {
        civilIDFieldGet.clear();
        OperationsField.clear();
        firstNameField.clear();
        lastNameField.clear();
        ageField.clear();
        mobileField.clear();
    }

    public void clearCivilInfo(){
        civilIDFieldGet.clear();
        firstNameField.clear();
        lastNameField.clear();
        ageField.clear();
        mobileField.clear();
    }

}
