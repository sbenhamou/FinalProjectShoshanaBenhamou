package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.ArrayList;
import java.util.List;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Values")
    public static String getValue(String jPath){
        response = ApiActions.get();
//        response.prettyPrint();
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Put new value in the store")
    public static void putValue(String main_key, String value){
        params.put("value", value);
        params.put("main_key", main_key);
        ApiActions.put(params);
    }

    @Step("Business Flow: Update value in the store")
    public static void updateValue(String main_key, String value){
        params.put("value", value);
        params.put("main_key", main_key);
        ApiActions.post(params);
    }

    @Step("Business Flow: Delete value from the store")
    public static void deleteValue(String main_key){
        params.put("main_key", main_key);
        ApiActions.delete(params);
    }

    @Step("Business Flow: Get number of main_key value in the json response")
    public static int countTagInResponse(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return jp.get("main_key.size()");
    }

    @Step("Business Flow: Get all main_key from the store")
    public static List<String> getAllMainKey(){
        List<String> mainKeyValues = new ArrayList<>();
        for (int i = 0; i < countTagInResponse(getValue("")); i++) {
            mainKeyValues.add(getValue("main_key["+i+"]"));
        }
        return mainKeyValues;
    }

    @Step("Empty the store")
    public static void emptyStore(){

        for (String mainKey : getAllMainKey()){
            params.put("main_key", mainKey);
            ApiActions.delete(params);
        }
    }
}
