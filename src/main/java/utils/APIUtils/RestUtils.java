package utils.APIUtils;

import com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public Response postRequest(String endPoint, HashMap<String, String> headers, String body) {
        return given()
                .log().all()
                .headers(headers)
                .body(body)
                .when()
                .post(endPoint);
    }

    public Response postRequest(String endPoint, HashMap<String, String> headers, HashMap<String, String> body) {
        return given()
                .log().all()
                .headers(headers)
                .body(new Gson().toJson(body))
                .when()
                .post(endPoint);
    }

    public Response patchRequest(String endPoint, HashMap<String, String> headers, String body) {
        return given()
                .log().all()
                .headers(headers)
                .body(body)
                .when()
                .patch(endPoint);
    }

    public Response getRequest(String endPoint, HashMap<String, String> params, HashMap<String, String> headers) {
        return given()
                .log().all()
                .params(params)
                .headers(headers)
                .when()
                .get(endPoint);
    }

    public int getStatusCode(Response response) {
        return response.statusCode();
    }

    public void validateJsonSchema(Response response, String schemaPath){
        response.then().assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath(schemaPath)
                        .using(JsonSchemaValidatorSettings.settings().with().checkedValidation(false)));
    }
}
