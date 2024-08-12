package commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class BaseTest extends Utility {

    static {
        propertyInit(); // Ensure properties are initialized
    }

    public static int lastID = getLastId();
    public static int copy;
    public static String[] arr;

    static int getLastId() {
        String message = RestAssured.get(Utility.prop.getProperty("base-url")).getBody().asString();
        String[][] wordsArray = splitParagraph(message);
        int l = wordsArray.length;
        int last = Integer.parseInt(wordsArray[0][2]);
        arr = wordsArray[0];
        for (int i = 1; i < l; i++) {
            if( Integer.parseInt(wordsArray[i][2]) > last){
                last = Integer.parseInt(wordsArray[i][2]);
                arr = wordsArray[i];
            }
        }
        copy=last;
        return last;
    }

    static String[][] splitParagraph(String paragraph) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
        List<Map<String, String>> dataList = gson.fromJson(paragraph, listType);

        String[][] wordsArray = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            Map<String, String> data = dataList.get(i);
            wordsArray[i] = new String[] {
                    data.get("FirstName"),
                    data.get("LastName"),
                    data.get("ID"),
                    data.get("Age"),
                    data.get("Mobile")
            };
        }
        return wordsArray;
    }
}