package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;



public class ApiActions extends CommonOps {

    @Step("Get Data from the store")
    public static Response get(){
        response = httpRequest.get();
//        response.prettyPrint();
        return response;}

    @Step("Extract Value From JSOM Format")
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Put value to the store")
    public static void put(JSONObject params){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put();
//        response.prettyPrint();
        }

    @Step("Update value on the store")
    public static void post(JSONObject params){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post();
//        response.prettyPrint();
    }

    @Step("Delete value from the store")
    public static void delete(JSONObject params) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.delete();
//        response.prettyPrint();
    }


}
