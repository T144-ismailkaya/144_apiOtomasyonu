package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C06_POST_RessponseBodyTesti {

    /*
    C6_Post_ResponseBodyTesti
       https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request gonderdigimizde
                {
                “title”:“API”,
                “body”:“API ogrenmek ne guzel”,
                 “userId”:10,
                }
    donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body’sindeki,
           “title”’in “API” oldugunu
           “userId” degerinin 100’den kucuk oldugunu
           “body” nin “API” kelimesi icerdigini
        test edin.
     */

    @Test
    public void test07(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("title","API");
        reqBody.put("userId",10);

        Response response = given().contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post(url);

        response.then().assertThat().statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));
    }

}
