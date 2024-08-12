import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagementPage;

public class GetAll extends BaseTest {

    @Test
    public void test_getAll() {
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickGetAllButton();
        Assert.assertNotEquals(managementPage.getMessage().length(), 0);
    }
}
