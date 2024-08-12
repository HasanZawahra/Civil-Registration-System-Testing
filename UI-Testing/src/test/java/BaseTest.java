import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ManagementPage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseTest extends Utility {

    WebDriver driver;
    int lastID,copy;
    static Map<String, String> lastIdObject;

    @BeforeClass()
    public void setUp() {
        propertyInit();
        System.setProperty(prop.getProperty("Browser"), prop.getProperty("location"));
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickGetAllButton();
        String message = managementPage.getMessage();
        String[][] wordsArray = splitParagraph(message);
        int l = wordsArray.length;
        lastID = Integer.parseInt(wordsArray[0][2]);
        for (int i = 1; i < l; i++) {
            if( Integer.parseInt(wordsArray[i][2]) > lastID){
                lastID = Integer.parseInt(wordsArray[i][2]);
            }
        }
        copy=lastID;
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    public static Map<String, String> findLastIdObject(List<Map<String, String>> dataList) {
        Map<String, String> lastIdObject = dataList.get(0);
        int lastId = Integer.parseInt(lastIdObject.get("ID"));
        for (Map<String, String> data : dataList) {
            int currentId = Integer.parseInt(data.get("ID"));
            if (currentId > lastId) {
                lastId = currentId;
                lastIdObject = data;
            }
        }
        return lastIdObject;
    }


    public static String[][] splitParagraph(String paragraph) {
        String[] records = paragraph.split("\\n\\n");
        List<Map<String, String>> dataList = new ArrayList<>();
        for (String record : records) {
            String[] keyValuePairs = record.split("\\n");
            Map<String, String> data = new HashMap<>();
            for (String keyValuePair : keyValuePairs) {
                String[] keyValue = keyValuePair.split(":\\s*");
                data.put(keyValue[0].replace(" ", ""), keyValue[1].trim());
            }
            dataList.add(data);
        }
        lastIdObject = findLastIdObject(dataList);
        Gson gson = new Gson();
        String jsonString = gson.toJson(dataList);
        Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
        List<Map<String, String>> parsedDataList = gson.fromJson(jsonString, listType);
        String[][] wordsArray = new String[parsedDataList.size()][];
        for (int i = 0; i < parsedDataList.size(); i++) {
            Map<String, String> data = parsedDataList.get(i);
            wordsArray[i] = new String[] {
                    data.get("FirstName"),
                    data.get("LastName"),
                    data.get("ID"),
                    data.get("Age"),
                    data.get("MobileNumber")
            };
        }
        return wordsArray;
    }
}